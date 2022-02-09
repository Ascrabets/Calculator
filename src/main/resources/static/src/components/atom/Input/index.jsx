import './style.css'
import React from "react";



export const Input = ({...props}) => {
    return (
        <div>
            <input className="input" type="text" {...props}/>
        </div>
)
}