import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/v1/calculate'

export default class API {
    static async calculate(operand1, operand2, operation) {
        return await axios.post(BASE_URL, {
            operand1: operand1,
            operand2: operand2,
            operation: operation
        }).then(response => {return response.data});
    }
}