<template>
<div class="container">
   <div class="row">
    <div class="col-sm">
     <div class="photo">
         <img style="margin-left:-96px; " src='https://i.pinimg.com/474x/77/18/10/771810fc008ed3be617787ce74e86bda--emeralds-alberta-canada.jpg'/>
      </div>
    </div>
    <div class="col-sm">
    
      <div class="card card-container">
        <div>
         <h2> Please, Sign in! </h2>
        </div>
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
             <form class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" v-model="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" v-model="inputPassword" class="form-control" placeholder="Password" required>
                
              <button class="btn btn-lg btn-primary btn-block btn-signin"
               type="submit" 
                v-on:click.prevent="signIn()"
                > Sign in </button>  
                
                
            </form><!-- /form -->     
                   
            <a href="http://localhost:3000/Registration" 
            class="btn btn-lg btn-primary btn-block btn-signin" 
            style="text-align: center; padding-top: 5px;" > Create account? </a>

            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
      </div>
    <button class="btn btn-lg btn-primary btn-block btn-signin"
               type="submit" 
                v-on:click.prevent="signIn2()"
                > Sign in </button> 
  </div>


      
        
    </div><!-- /container -->
</template>


<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



export default {
  data() {
    return {
       inputEmail: "",
       inputPassword: "",      
     
    }
  },
  mounted() {
       
    },
     methods:
     {     
         signIn2: function()
         {
            console.log("AAAA");
         }   ,      
        signIn: function()
      {
          if(this.inputEmail!="" && this.inputPassword != "")
          {
               const userLogin = 
                {
                    username: this.username,
                    password: this.password
                }

              this.axios.post('/user/login', userLogin, {
                    headers: 
                    {          
                         
                        
                    }}).then(response => 
                    {                        
                        localStorage.setItem('accessToken', response.data.accessToken);
                        localStorage.setItem('expiresIn', new Date(new Date().getTime() + response.data.expiresIn).getTime());
                        this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + response.data.accessToken;
                        //console.log(response.data);
                                
                                this.axios.get('/user/loggedUser', {
                                headers: 
                                {          
                                    //'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {    
                                    console.log("ENABLE: " + response.data.accountEnabled);
                                    console.log("Autoritu: " + response.data.authorityRole);
                                    if(response.data.authorityRole === "ROLE_ADMIN")
                                    {
                                        console.log("Prijava admina");
                                        console.log(response.data);
                                        //this.$router.push('SystemAdminProfile/' + response.data.id);
                                        
                                    }
                                    else if(response.data.authorityRole === "ROLE_PATIENT")
                                    {
                                            this.$router.push('HomePagePatient/'+ response.data.id);
                                    }
                                    
                                    else
                                    {
                                        console.log(response.data);
                                        alert("User has no authority!");
                                    }
                                                                                                           
                                }).catch(res => {                 
                                    
                                    console.log("GRESKA");
                                    console.log(res.response);
                                    this.errorMessage = res.response.data.message;
                                });       
                                 }).catch(res => { 
                        if(res.response.status === 401)
                           alert("Wrong password or email.");
                        
                        console.log(res.response);
                        this.errorMessage = res.response.data.message;
                       
                    });    
          }
          else
          {
              alert("Please, you didnt fill the fields!");
          }
      },
      
   
}
}

</script>





<style>
body, html {
    
    background-repeat: no-repeat;
    /*background-image: url('https://scx2.b-cdn.net/gfx/news/hires/2019/2-forest.jpg');*/

    /*background-image: url('https://i.pinimg.com/474x/77/18/10/771810fc008ed3be617787ce74e86bda--emeralds-alberta-canada.jpg');*/
    background-position: center;
    /*background-size: 100% 100%;
    background-size: cover;*/
    background-repeat: no-repeat;
    height: 100%;
    /*background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
}
.photo
{
   position: left;
}
.row
{
   /*background-color:red;*/

   background-color: #bdd4e7;
   background-image: linear-gradient(315deg, #bdd4e7 0%, #8693ab 74%);

}


.card-container.card {
    max-width: 500px;
    margin-top:30%;
    margin-left: -6%;
    padding: 40px 40px;
    text-align:center;
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


<script>
export default {
  data() {
    return {
      registerActive: false,
      emailLogin: "",
      passwordLogin: "",
      emailReg: "",
      passwordReg: "",
      confirmReg: "",
      emptyFields: false
     
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
      }
      
      }
   
}
</script>