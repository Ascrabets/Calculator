import './style.css'
import {OperationBoard} from "../../molecule/OperationBoard";
import {InputBoard} from "../../molecule/InputBoard";
import {Icon} from "../../atom/Icon";
import {useSelector} from "react-redux";
import {Button} from "../../atom/Button";

export const Board = () => {
    const operationSelector = useSelector(state => state);

    const handleSubmit = (event) => {
        const formData = new FormData(event.currentTarget);
        event.preventDefault();
        for (let [key, value] of formData.entries()) {
            console.log(key, value);
        }
    }

    return (
        <div className="board-container">
            <div className="board-content">
                <form onSubmit={handleSubmit}>
                    <InputBoard>
                        <Icon>
                            {operationSelector['operation']}
                        </Icon>
                    </InputBoard>
                    <OperationBoard/>
                    <div className="answer-button">
                        <Button type="submit" style={{width: "145px", height: "50px", background: "#FF3A3A", color: "#FFFF"}}>
                            =
                        </Button>
                    </div>
                </form>
            </div>
        </div>
    )
}