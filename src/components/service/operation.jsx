function isPrime(n) {
    for(let i = 2; i <= Math.sqrt(n)
        ; i += 1) {
        if (n % i === 0){
            return false;
        }
    }
    return true;
}

export function calculateGreatestPrimeInRange(low, high) {
    const primes = [];
    for (let i = low; i <= high; i += 1) {
        if (isPrime(i)) primes.push(i);
    }
    return primes.length ? primes.pop() : -1;
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
