
function reducer(state, action){
    switch (action.type) {
        case '+':
            return {
                operation: "+"
            };
        case "/":
            return {
                operation: "/"
            };
        case "%":
            return {
                operation: "%"
            };
        case "h":
            return {
                operation: "hp"
            };
        default:
            return "+";
    }
}

export default reducer;