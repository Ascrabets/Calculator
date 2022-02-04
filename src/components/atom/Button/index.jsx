import "./style.css"
import React from "react";
import {useDispatch} from "react-redux";

export const Button = ({children, ...props}) => {
    return (
        <div className="button-container" {...props}>
            <span>{children}</span>
        </div>
    )
};