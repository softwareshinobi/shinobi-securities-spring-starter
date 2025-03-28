//alert("member login!");

$(document).ready(function () {

    console.log("list / cookies / all");

    console.log(Cookies.get());

});

function onLogin() {

console.log("user is trying to login w/ button");

 var username = $("#username").val();
    console.log("Username entered:", username);

    var password = $("#password").val();
    console.log("Password entered:", password);
    
  // Capture the state of the terms and policy checkbox
    var rememberme = $("#rememberme").prop("checked");
    console.log("User Wants To Stay Logged In:", rememberme);


    $.ajax({

      url: "http://localhost:8888/api/auth/signin",

      type: "POST",

      contentType: "application/json",

      data: JSON.stringify({ username: username, password: password }),

      dataType: "json", // Expect JSON response from the server

        success: function(data) {

            console.log("success. server response:", data);

            $("#successAlert").removeClass("d-none"); // Show success alert

            $("#errorAlert").addClass("d-none");   // Hide error alert

          //  $("#signupForm")[0].reset(); // Clear the form

            window.location.replace("home.html");
        },
      error: function(xhr, status, error) {
        // Handle errors during user creation
        console.error("Error creating user:", xhr.responseJSON || xhr.responseText);
        $("#errorAlert").removeClass("d-none"); // Show error alert
        $("#successAlert").addClass("d-none");  // Hide success alert
        var errorMessage = "An error occurred during signup.";
        if (xhr.responseJSON && xhr.responseJSON.message) {
          errorMessage = xhr.responseJSON.message; // Use server-provided error message
        } else if (xhr.responseText) {
          errorMessage = xhr.responseText;
        }
        $("#errorMessage").text(errorMessage); // Display the error message
      }
    });

}

function loginUser() {

	console.debug("enter > loginUser");	

	console.log("list / cookies / before");

	console.log(Cookies.get());

	Cookies.set(KEY_USERNAME, $("#userName").val(), { path: '/' , expires: 365 })

	console.log("list / cookies / after");

	console.log(Cookies.get());

	console.log("list / cookies / ", KEY_USERNAME);

	console.log(Cookies.get(KEY_USERNAME));

	console.debug("exit < loginUser");	

	window.location.replace("../dashboard.html");

}
