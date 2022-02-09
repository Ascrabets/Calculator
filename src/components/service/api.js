import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/v1/calculate'

const call = async (operand1) => {
    return await axios.post(BASE_URL, {
        operand1: operand1,
    })
}
 function abc() {
call.then((data) => {
    console.log(data);
})};


export default class API {
    static async calculate(operand1, operand2, operation) {
        return await axios.post(BASE_URL, {
            operand1: operand1,
            operand2: operand2,
            operation: operation
        }).then(response => {return response.data});
    }
}