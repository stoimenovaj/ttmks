// The forwardRef is important!!
// Dropdown needs access to the DOM node in order to position the Menu
import * as React from "react";
import {useState} from "react";
import FormControl from "react-bootstrap/FormControl";

export const CustomToggle = React.forwardRef(({ children, onClick }, ref) => (
    <button
        className={"btn btn-light btn-block"}
        ref={ref}
        onClick={e => {
            e.preventDefault();
            onClick(e);
        }}
    >
        {children}
        &#x25bc;
    </button>
));

// forwardRef again here!
// Dropdown needs access to the DOM of the Menu to measure it
export const CustomMenu = React.forwardRef(
    ({ children, style, className, 'aria-labelledby': labeledBy }, ref) => {
        const [value, setValue] = useState('');

        return (
            <div
                ref={ref}
                style={style}
                className={className}
                aria-labelledby={labeledBy}
            >
                <FormControl
                    autoFocus
                    className="mx-3 my-2 w-auto"
                    placeholder="Внеси филтер..."
                    onChange={e => setValue(e.target.value)}
                    value={value}
                />
                <ul className="list-unstyled">
                    {React.Children.toArray(children).filter(
                        child =>
                            !value || child.props.children.toLowerCase().startsWith(value),
                    )}
                </ul>
            </div>
        );
    },
);