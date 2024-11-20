<!DOCTYPE html>
<html>
<head>
    <title>JSP Scripting Elements Example</title>
</head>
<body>
    <h2>Demonstration of JSP Scripting Elements</h2>

    <!-- Declaration: Define variables and methods -->
    <%! 
        // Declare variables
        int num1 = 10;
        int num2 = 20;

        // Declare a method to calculate the sum
        public int calculateSum(int a, int b) {
            return a + b;
        }
    %>

    <!-- Scriptlet: Java logic inside the JSP -->
    <%
        // Use the declared method and variables
        int sum = calculateSum(num1, num2);
        String message = "The sum of " + num1 + " and " + num2 + " is " + sum;
    %>

    <!-- Expression: Output the result directly -->
    <p>
        Using Declaration and Scriptlet: 
        <%= message %>
    </p>

    <p>
        Using Expression directly: 
        <%= "Today's date is: " + new java.util.Date() %>
    </p>

</body>
</html>
