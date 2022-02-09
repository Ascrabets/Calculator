import React from "react";
import '../Button/style.css'

export const SubmitButton = ({children, ...props}) => {
    return (
        <button className="button-container submit-button" {...props}>
            <span>{children}</span>
        </button>
    )
};