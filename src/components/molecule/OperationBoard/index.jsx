import "./style.css"
import {Button} from "../../atom/Button";
import {useDispatch} from "react-redux";

export const OperationBoard = () => {
    const dispatch = useDispatch();

    return (
        <div className="operation-container">
            <Button onClick={() => dispatch({type: "+"})}>
                +
            </Button>
            <Button onClick={() => dispatch({type: "/"})}>
                /
            </Button>
            <Button onClick={() => dispatch({type: "%"})}>
               %
            </Button>
            <Button onClick={() => dispatch({type: "h"})}>
              hp
            </Button>
        </div>
    )
}