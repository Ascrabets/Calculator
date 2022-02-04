import './style.css'
import {Input} from "../../atom/Input";
import {Icon} from "../../atom/Icon";


export const InputBoard = ({children}) => {
    return (
        <div className="input-container">
            <Input/>
            <span>{children}</span>
            <Input/>
            <Icon>=</Icon>
            <Input readOnly/>
        </div>
    )
}
