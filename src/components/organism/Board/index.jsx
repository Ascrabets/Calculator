import './style.css'
import {OperationBoard} from "../../molecule/OperationBoard";
import {Icon} from "../../atom/Icon";
import {useSelector} from "react-redux";
import {Button} from "../../atom/Button";
import {Input} from "../../atom/Input";
import {useState} from "react";
import {Calculation} from "../../service/operation";
import {useModal} from "react-hooks-use-modal";
import {History} from "../../hisrory/History";

export const Board = () => {
    const [formData, setFormData] = useState({});
    const operationSelector = useSelector(state => state);

    const [Modal, open, close] = useModal('root', {
        preventScroll: false,
        closeOnOverlayClick: true
    });

    const onSubmit = (event) => {
        event.preventDefault();
        let result = Calculation(formData['numberOne'], formData['numberTwo'], operationSelector['operation'])
        setData('result', result);
        saveResult();
    };

    const getData = (key) => {
        return formData.hasOwnProperty(key) ? formData[key] : '';
    };

    const setData = (key, value) => {
        return setFormData((() => ({...formData, [key]: value})));
    };

    function onChangeData(e, key) {
        const re = /^-?\d+\.?\d*$/;
        if (e.target.value === '' || re.test(e.target.value)) {
            setData(key, e.target.value);
        }
    }

    const saveResult = () => {
        const history = JSON.parse(localStorage.getItem('history')) || [];
        history.push(`${formData['numberOne']}${operationSelector['operation']}${formData['numberTwo']}=${Calculation(formData['numberOne'], formData['numberTwo'], operationSelector['operation'])}`);
        localStorage.setItem('history', JSON.stringify(history));
    };

    return (
        <div className="board-container">
            <div className="board-content">
                <div className="input-container">
                    <Input id="numberOne" value={getData('numberOne')} onChange={(e) => onChangeData(e, 'numberOne')}/>
                    <span>
                            <Icon>
                                {operationSelector['operation']}
                            </Icon>
                        </span>
                    <Input id="numberTwo" value={getData('numberTwo')} onChange={(e) => onChangeData(e, 'numberTwo')}/>
                    <Icon>=</Icon>
                    <Input value={getData("result")} id="answer" readOnly/>
                </div>
                <OperationBoard/>
                <div className="answer-button">
                    <Button onClick={open}
                            style={{width: "145px", height: "50px", background: "#FF3A3A", color: "#FFFF"}}>
                        History
                    </Button>
                    <Button onClick={onSubmit} type="submit"
                            style={{width: "145px", height: "50px", background: "#FF3A3A", color: "#FFFF"}}>
                        =
                    </Button>
                </div>
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