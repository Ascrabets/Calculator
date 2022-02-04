import './style.css'
import {Input} from "../../atom/Input";
import {Icon} from "../../atom/Icon";


export const InputBoard = ({children}) => {
    return (
        <div className="input-container">
            <Input id="numberOne"/>
            <span>{children}</span>
            <Input id="numberTwo"/>
            <Icon>=</Icon>
            <Input readOnly/>
        </div>
    )
}
