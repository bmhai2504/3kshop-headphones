function login() {
      if (validateEmail($("#emailLogin").val())) 
      {
            let userRequestLogin = JSON.stringify({
                  email: $("#emailLogin").val(),
                  password: $("#passwordLogin").val()
            });

            $.ajax({
                  url: "http://localhost:8080/api/auth/login",
                  type: "POST",
                  data: userRequestLogin,
                  dataType: "json",
                  contentType: "application/json",
                  success: (response) => {
                        console.log(response.role);
                        localStorage.setItem("token", response.token);
                        localStorage.setItem("name", response.name);
                        if(response.role == "ADMIN"){
                              window.location.href = "http://127.0.0.1:5500/html/admin.html";
                        }else{
                              window.location.href = "http://127.0.0.1:5500/html/index.html";
                        }
                        
                  },
                  error: (error) => {
                        console.log(error);
                        alert("Login Failed, Please Login Again!!!");
                        window.location.href = "http://127.0.0.1:5500/html/login.html";
                  }
            })
      } 
      else 
      {
            let email = document.forms["loginForm"]["emailLogin"].value;
            let password = document.forms["loginForm"]["passwordLogin"].value;
            if (email == "" || password == "") {
                  alert("Input Box must be filled out !!!");
            }else{
                  alert("Email Not Valid !!!");
            }
            window.location.href = "http://127.0.0.1:5500/html/login.html";
      }

}

function register(){

      if (validateEmail($("#email").val())) 
      {     
            let password = $("#password").val();
            console.log(password);
            let repeatPasword = $("#repeatPassword").val();
            console.log(repeatPasword);
            if(password == repeatPasword){
                  let userRequestLogin = JSON.stringify({
                        email: $("#email").val(),
                        name : $("#name").val(),
                        password: $("#password").val()
                  });
      
                  $.ajax({
                        url: "http://localhost:8080/api/auth/register",
                        type: "POST",
                        data: userRequestLogin,
                        dataType: "json",
                        contentType: "application/json",
                        // Authorization : "Bearer " + "",
                        success: () => {
                              if(alert("Register Success !!!")){
                                    window.location.href = "http://127.0.0.1:5500/html/login.html";
                              }
                              window.location.href = "http://127.0.0.1:5500/html/login.html";
                        },
                        error: (error) => {
                              console.log(error);
                              alert("Register Failed, Please Register Again!!!");
                              window.location.href = "http://127.0.0.1:5500/html/register.html";
                        }
                  })
            } 
            else
            {
                  alert("Password and Repeat Password Not Match !!!");
                  window.location.href = "http://127.0.0.1:5500/html/register.html";
            }
            
      }else {
            alert("Email Not Valid !!!");
            window.location.href = "http://127.0.0.1:5500/html/register.html";
      }
}

function validateEmail(email) {
      var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      if (email.match(mailformat)) {
            return true;
      }
      else {
            return false;
      }
}