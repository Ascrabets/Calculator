import "./style.css"
import {Button} from "../../atom/Button";
import {useDispatch} from "react-redux";

export const OperationBoard = () => {
    const dispatch = useDispatch();

    return (
        <div className="operation-container">
            <Button onClick={() => dispatch({type: "add"})}>
                +
            </Button>
            <Button onClick={() => dispatch({type: "divide"})}>
                /
            </Button>
            <Button onClick={() => dispatch({type: "mod_divide"})}>
               %
            </Button>
            <Button onClick={() => dispatch({type: "hp"})}>
              hp
            </Button>
        </div>
    )
}