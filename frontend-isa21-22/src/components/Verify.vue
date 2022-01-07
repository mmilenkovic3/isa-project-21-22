<template>
    <div :class="{confirm:!this.active, notConfirm:this.active}" >    
    <div class="text">
        <h2 style="margin-top:40px;"> {{ this.success }}</h2>
        <p> {{ this.continue }} </p>
    </div>
        <button v-if="!this.active" style="margin-top:20px; height: 50px;" v-on:click="accountEnabled()" class="btn btn-lg btn-primary btn-block btn-signin"> Continue </button>
        <button v-if="this.active"  style="margin-top:20px; height: 50px;" v-on:click="signIn()"  class="btn btn-lg btn-primary btn-block btn-signin2"> Sign in </button>
    </div>  
</template>

<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


export default {
  data() {
    return {
      success: "Successeffully registrated!",
      user: {},
      id : this.$route.params.id,
      active : false,
      continue: "Please, click continue to open your profile." ,
      
    }
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
             
      
      },
      signIn: function()
      {
        this.$router.push('/SignIn'); 
      },
      accountEnabled: function()
      {
          this.axios.post('/user/changeEnabledStatus/'+ this.$route.params.id,
                {
                    headers: 
                    {
                       
                    }}).then(response => 
                    {                        
                        alert("Success");
                        console.log(response.data);                                             

                    }).catch(res => {
                        console.log(res);
                    });
      }

      
   
},
mounted() {
    console.log(this.$route.params.id);
   
      this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                {
                    headers: 
                    {
                       
                    }}).then(response => 
                    {                        
                        console.log(response);
                        if(response.data.accountEnabled)
                        { 
                            this.active = true;
                            this.success = "You allready verify your account!"
                            this.continue = "Please sing in to continue... "
                        }                        

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();
                    });  
    },
}

</script>
<style>
.text{  
    padding: 10px;
    margin-top: 50px;
}
.confirm
{
    color: black;
    height: 200px;
    width: 800px;
    background-color: #a0deaa;
    margin: 0 auto;
}
.notConfirm
{
    height: 200px;
    width: 800px;
    color: black;
    background-color: #ffe66b;
    margin: 0 auto;
}

.btn.btn-signin2 {
    /*background-color: #4d90fe; */
    background-color: rgb(255, 180, 99);
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
    color: black;
}

.btn.btn-signin2:hover,
.btn.btn-signin2:active,
.btn.btn-signin2:focus {
    background-color: rgb(255, 150, 25);
}

</style>