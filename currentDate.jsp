<!DOCTYPE html>
<html>
<head>
    <title>Current Date and Time</title>
</head>
<body>
    <h2>Current Date and Time</h2>
    <p>
        <% 
            // Import required package
            java.util.Date currentDate = new java.util.Date();
            // Display current date and time
            out.println("The current date and time on the server is: " + currentDate.toString());
        %>
    </p>
</body>
</html>
