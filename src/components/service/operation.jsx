const isPrime = num => {
    let count = 2;
    while(count < (num / 2)+1){
        if(num % count !== 0){
            count++;
            continue;
        }
        return false;
    }
    return true;
};
export const primeBetween = (numberOne, numberTwo) => {
    let count = 0;
    for(let i = Math.min(numberOne, numberTwo); i <= Math.max(numberOne, numberTwo); i++){
        if(isPrime(i)){
            count++;
        }
    }
    return count;
};

export const Calculation = (numberOne, numberTwo, type) => {
    switch (type) {
        case "+":
            return parseFloat(numberOne) + parseFloat(numberTwo);
        case "/":
            return parseFloat(numberOne) / parseFloat(numberTwo);
        case "%":
            return parseFloat(numberOne) % parseFloat(numberTwo);
        case "hp":
            return primeBetween(numberOne, numberTwo)
    }
}