## Reverse engineering of models

Create reverse engineered entity java classes for ORMs based on your database tables - by using `mvn`, `ant` and `Hibernate` tools

Based on this [tutorial](https://eugencovaciq.wordpress.com/2016/02/01/hibernate-tools-reverse-engineering-using-maven/).

You need to have `Apache Maven` installed and setup so that it is in your system PATH and can be called with just "mvn" from the command line.

#### Step 1. Open `hibernate.cfg.xml` and setup for access to your database
- Check hibernate documentation for help

#### Step 2. Open `hibernate.reveng.xml` to setup custom Java - Hibernate - SQL mappings, or to filter tables
- Have in mind that hibernate tools will reverse engineer all tables from all schemas, unless you configure filtering
- Check hibernate documentation for help

#### Step 3. Open `pom.xml` in case you need to update Hibernate tools and libraries to latest versions, or to include other `JDBC` driver/version.
- Make sure the path where java code is generated is correct
- Make sure the path hibernate xml files are correct

#### Step 4. Open command line in this directory and run the following command in order to compile and install for later usage the custom reverse engineering strategy that is available in `src/` directory. This step is not needed if this strategy is disabled in `hibernate.reveng.xml`

`mvn install`

#### Step 5. Run this only once to generate the Java source files for the first time.

`mvn antrun:run@hbm2java`

#### Step 6. If not satisfied with the generated Java source files, change the XML files, see the tutorial and see hibernate docs for custom configuration
- If you need custom naming patterns for the java classes, java properties or methods, you will need to modify the customized Reverse Strategy. Please see the tutorial and hibernate docs for this.
- If you have changed too many configurations, it is better to remove the previous source files before going back to Step 4 to generate again.

If you are satisfied with the generated source files for the model mapping of Entity classes via Hibernate ORM, you can proceed to build you application directly here.

The generated source files do not have a mapping "schema" defined. So if you want to have your tables in the database in a specific schema, you will have to add that to the `@Table` annotation. This can be done easily on linux with the following one-line command.

`sed -i 's/@Table(name/@Table(schema=\"project\",name/g' entitities/*java`

Finally, if you want to clean all the generated code and start a new run:

`mvn clean`
