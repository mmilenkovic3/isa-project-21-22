<template>
<div class="container-registration2">
   
    
      <div class="card card-container2 ">
        <div>
         <h2> Your information: </h2>
        </div>
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
             <form class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text"  v-model="inputName" class="form-control" placeholder="Name" required>
                <input type="text" v-model="inputSurName" class="form-control" placeholder="Surname" required>
               <input type="text" v-model="inputAddress" class="form-control" placeholder="Address" required>
               <input type="text" v-model="inputPhoneNum" class="form-control" placeholder="Phone number" required>
               <input type="text" v-model="inputCity" class="form-control" placeholder="City" required>
               <input type="text" v-model="inputCountry" class="form-control" placeholder="Country" required>
                <input type="email" v-model="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" v-model="inputPassword" class="form-control" placeholder="Password" required>
                <input type="password" v-model="inputRepeatPassword" class="form-control" placeholder="Repeat Password" required>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click.prevent="registrateNewUser();"> Create account </button>
            


   
                  
            </form><!-- /form -->

              
            
        </div><!-- /card-container -->
      
    
 


      
        
    </div><!-- /container -->
</template>

<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


export default {
  data() {
    return {
      inputName: "",
      inputSurName: "",
      inputAddress: "",
      inputPhoneNum: "",
      inputCity: "",
      inputCountry: "",
      inputEmail: "",
      inputPassword: "",
      inputRepeatPassword: ""
     
    }
  },
  mounted() {
       
    },
     methods:{              
    doLogin() {
         if (this.emailLogin === "" || this.passwordLogin === "") {
            this.emptyFields = true;
         } else {
            alert("You are now logged in");
         }
      },
      registrateNewUser: function()
      {
          console.log("pozvana");
          

            if(this.inputName != "" && this.inputSurName != "" && this.inputAddress != ""
            && this.inputCity != "" && this.inputCountry != "" && this.inputEmail != "" 
            && this.inputPassword != "" && this.inputRepeatPassword != "" && this.inputPhoneNum != "")
            {
                    if(this.inputPassword != this.inputRepeatPassword) 
                    {
                        alert("Password are not the same!");
                        this.inputRepeatPassword = "";
                        this.inputPassword = "";
                        event.preventDefault();
                    }
                    else
                {
                    console.log("SVE POPUNJENO? " ); 
                const user = 
                            {
                                name : this.inputName,
                                surname : this.inputSurName,
                                email : this.inputEmail,   
                                password: this.inputPassword,             
                                address : this.inputAddress,
                                phoneNumber : this.inputPhoneNum,
                                city : this.inputCity,
                                country : this.inputCountry
                            }  

                    console.log(user); 
                
                this.axios.post('user/saveUser', user,
                {
                    headers: 
                    {
                        //'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                        alert("Success! Email verification is send to " + this.inputEmail);
                        console.log(response);
                        this.$router.push('/LoginPage');  

                    }).catch(res => {
                        console.log(res);
                        alert("User with this email already existas!");
                        event.preventDefault();

                    });     
                }

            }
            else
            {
                alert("Please, fill the fields!");
            }
                 
             
      
      }
   
}
}

</script>

<style>

.container-registration2
{overflow-y: hidden; 
    background-image: url('https://i.pinimg.com/originals/e8/65/e2/e865e27b08e871418e9f19e122937d1b.jpg');
    background-position: center;
    background-size: 100% 100%;
    background-size: cover;
    background-repeat:repeat;
    display: block;
    height: 100%;
    overflow-y: hidden; 
    width: 100%; 
    position: absolute;
      bottom: 0px;
      
     background-position: 50%;
    
}



.card-container2.card {
    margin: 0 auto;
    display: block;
    margin-top: 5%;
    max-width: 500px;   
    position: 50%;
    padding: 40px 40px;    
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}


/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}

.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162);
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
    /*background-color: #4d90fe; */
    background-color: rgb(104, 145, 162);
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}
</style>


