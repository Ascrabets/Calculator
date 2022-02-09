import "./style.css"
import React from "react";

export const Button = ({children, ...props}) => {
    return (
        <div className="button-container" {...props}>
            <span>{children}</span>
        </div>
    )
};