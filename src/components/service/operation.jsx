function isPrime(n) {
    for (let i = 2; i <= Math.sqrt(n)
        ; i += 1) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

export function calculateGreatestPrimeInRange(low, high) {
    let prime = undefined;
    for (let i = high; i >= low; i -= 1) {
        if (isPrime(i)) {
            prime = i;
            break;
        }
    }
    return prime;
}

export const Calculation = (numberOne, numberTwo, type) => {
    switch (type) {
        case "+":
            return parseFloat(numberOne) + parseFloat(numberTwo);
        case "/":
            return parseFloat(numberOne) / parseFloat(numberTwo);
        case "%":
            return parseFloat(numberOne) % parseFloat(numberTwo);
        case "hp":
            return calculateGreatestPrimeInRange(numberOne, numberTwo)
    }
}
