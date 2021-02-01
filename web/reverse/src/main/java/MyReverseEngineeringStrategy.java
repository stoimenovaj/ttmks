import org.hibernate.cfg.reveng.*;

public class MyReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

   public MyReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
       super(delegate);
   }

   @Override
   public void setSettings(ReverseEngineeringSettings settings) {
       super.setSettings(settings);
   }

   @Override
   public boolean excludeForeignKeyAsCollection(String keyname, 
    TableIdentifier fromTable, java.util.List fromColumns, 
    TableIdentifier referencedTable, java.util.List referencedColumns) {

    return true;

   }
}

