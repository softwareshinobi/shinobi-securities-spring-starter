//alert("member create js!");

//$(document).ready(function () {
//
//	clearFormBoxes();	
//
//});

function onSubmit(){

console.log("hello?");

  var username = $("#username").val();
    console.log("Username entered:", username);

    var email = $("#email").val();
    console.log("Email entered:", email);

    var password = $("#password").val();
    console.log("Password entered:", password);

  // Capture the state of the terms and policy checkbox
    var termsAgreed = $("#termsAndPolicy").prop("checked");
    console.log("Terms and Policy Agreed:", termsAgreed);

    $.ajax({

      url: "http://localhost:8888/api/auth/signup",

      type: "POST",

      contentType: "application/json",

      data: JSON.stringify({ username: username, email: email, password: password }),

      dataType: "json", // Expect JSON response from the server

      success: function(data) {

        console.log("success. server response:", data);

        $("#successAlert").removeClass("d-none"); // Show success alert

        $("#errorAlert").addClass("d-none");   // Hide error alert

        $("#signupForm")[0].reset(); // Clear the form

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

function clearFormBoxes(){

	$("#userName").val("");

	$("#userPassword").val("");
    
}

function processCreateForm() {

    console.debug(" -> :: processCreateForm()");	

    //

	userName=$("#userName").val();

	console.debug("userName / " + userName);

	//
	
    userPassword=$("#userPassword").val();

	console.debug("userPassword / " + userPassword);

	//
	
	$.ajax({

		type: "POST",
		
		url: apiURL + "/trader/create",

        data: JSON.stringify({
        
            username: userName,

            password: userPassword,
       
        }),

		contentType: "application/json",
		
		crossDomain: true,
		
		dataType: "text",		

		success: function (data, status, jqXHR) {

            alert("account created: " + userName);

            console.log("response / ", data);

            window.location.replace("login.html");

		},

		error: function (exception, status) {

            alert("account NOT created");

			console.log("error creating trader / ", exception);

		}

	});
  
}
