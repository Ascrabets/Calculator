
export default function reducer(state, action){
    switch (action.type) {
        case 'add':
            return {
                operation: "+"
            };
        case "divide":
            return {
                operation: "/"
            };
        case "mod_divide":
            return {
                operation: "%"
            };
        case "hp":
            return {
                operation: "hp"
            };
        default:
            return "+";
    }
}

