import './style.css'
import {OperationBoard} from "../../molecule/OperationBoard";
import {Icon} from "../../atom/Icon";
import {useSelector} from "react-redux";
import {Button} from "../../atom/Button";
import {Input} from "../../atom/Input";
import {useState} from "react";
import {useModal} from "react-hooks-use-modal";
import {History} from "../../../hisrory/History";
import API from "../../../service/api";
import {SubmitButton} from "../../atom/SubmitButton";

export const Board = () => {
    const [formData, setFormData] = useState({});
    const operationSelector = useSelector(state => state);

    const [Modal, open] = useModal('root', {
        preventScroll: false,
        closeOnOverlayClick: true
    });

    const onSubmit = (event) => {
        event.preventDefault();
        let result = API.calculate(formData['numberOne'], formData['numberTwo'], operationSelector['operation'])
        result.then(result => {
            setData('result', result);
            saveResult(result);
        })

    };

    const getData = (key) => formData.hasOwnProperty(key) ? formData[key] : '';

    const setData = (key, value) => setFormData(((prevState) => ({...prevState, [key]: value})));

    function onChangeData(e, key) {
        const re = /^-?\d+\.?\d*$/;
        if (e.target.value === '' || re.test(e.target.value)) {
            setData(key, e.target.value);
        }
    }

    const saveResult = (result) => {
        const history = JSON.parse(localStorage.getItem('history')) || [];
        history.push(`${formData['numberOne']}${operationSelector['operation']}${formData['numberTwo']}=${result}`);
        localStorage.setItem('history', JSON.stringify(history));
    };

    return (
        <div className="board-container">
            <div className="board-content">
                <form onSubmit={onSubmit}>
                    <div className="input-container">
                        <Input id="numberOne" value={getData('numberOne')}
                               onChange={(e) => onChangeData(e, 'numberOne')}/>
                        <span>
                            <Icon>
                                {operationSelector['operation']}
                            </Icon>
                        </span>
                        <Input id="numberTwo" value={getData('numberTwo')}
                               onChange={(e) => onChangeData(e, 'numberTwo')}/>
                        <Icon>=</Icon>
                        <Input value={getData("result")} id="answer" readOnly/>
                    </div>
                    <OperationBoard/>
                    <div className="answer-button">
                        <Button onClick={open} className="custom-button button-container">
                            History
                        </Button>
                        <SubmitButton type="submit" className="custom-button button-container">
                            =
                        </SubmitButton>
                    </div>
                </form>
                <Modal>
                    <div className="pop-container">
                        <div className="pop-content">
                            <h1>History</h1>
                            <div className="history">
                                <History/>
                            </div>
                        </div>
                    </div>
                </Modal>
            </div>
        </div>
    )
}