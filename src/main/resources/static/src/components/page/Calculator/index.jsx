import './style.css'
import {Board} from "../../organism/Board";
import React from "react";


export const Calculator = () => {
    return (
        <div className="container">
            <div className="content">
                <Board/>
            </div>
        </div>
    )
}