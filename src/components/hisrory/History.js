import React, {useState} from 'react';
import {Button} from "../atom/Button";

export const History = () => {
    const [isHistory, setIsHistory] = useState(JSON.parse(localStorage.getItem('history')));

    const deleteHistory = () => {
        localStorage.removeItem('history');
        setIsHistory(undefined);
    }

    return (
        <div>
            <Button onClick={deleteHistory} type="submit"
                    style={{width: "100px", height: "50px", background: "#FF3A3A", color: "#FFFF"}}>
                clear
            </Button>

            {isHistory? isHistory.map((element, id) => (
                <p key={id}>{element}</p>
            )) : 'No history'}
        </div>
    )
}
