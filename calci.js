// Scientific Calculator (Console Version)

function scientificCalculator() {
    while (true) {
        console.log("\nScientific Calculator");
        console.log("1. Basic Operation (+, -, *, /)");
        console.log("2. Scientific Operation");
        console.log("3. Exit");

        const choice = prompt("Enter your choice (1-3):");

        switch (choice) {
            case "1":
                basicOperation();
                break;
            case "2":
                scientificOperation();
                break;
            case "3":
                console.log("Thank you for using the calculator. Goodbye!");
                return;
            default:
                console.log("Invalid choice. Please try again.");
        }
    }
}

function basicOperation() {
    const num1 = parseFloat(prompt("Enter first number:"));
    const operator = prompt("Enter operator (+, -, *, /):");
    const num2 = parseFloat(prompt("Enter second number:"));

    let result;
    switch (operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = num1 / num2;
            break;
        default:
            console.log("Invalid operator");
            return;
    }

    console.log(`Result: ${result}`);
}

function scientificOperation() {
    const operations = [
        'sin', 'cos', 'tan', 'log', 'ln', 'sqrt', 'square'
    ];

    console.log("Available operations:", operations.join(", "));
    const operation = prompt("Choose an operation:").toLowerCase();

    if (!operations.includes(operation)) {
        console.log("Invalid operation");
        return;
    }

    const num = parseFloat(prompt("Enter a number:"));
    let result;

    switch (operation) {
        case 'sin':
            result = Math.sin(num);
            break;
        case 'cos':
            result = Math.cos(num);
            break;
        case 'tan':
            result = Math.tan(num);
            break;
        case 'log':
            result = Math.log10(num);
            break;
        case 'ln':
            result = Math.log(num);
            break;
        case 'sqrt':
            result = Math.sqrt(num);
            break;
        case 'square':
            result = num * num;
            break;
    }

    console.log(`Result: ${result}`);
}

// Start the calculator
scientificCalculator();
