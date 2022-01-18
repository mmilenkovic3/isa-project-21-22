<template>
<div style = "width:50%; margin: 0 auto;">
    <h1> Welcome! Please login to continuee... </h1>
    <br>
 <input type="email" v-model="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" v-model="inputPassword" class="form-control" placeholder="Password" required>
                <br>
              <button class="btn btn-lg btn-primary btn-block btn-signin"
               type="submit" 
                v-on:click.prevent="signIn()"
                > Sign in </button>
                <br> 
                <p> You don't have account? </p>
                <v-btn class="btn btn-lg btn-primary btn-block btn-signin" to="/Registration"> Registration </v-btn>
</div>
</template>

<script>
export default{

    data()
    {
        return{
        inputEmail: "",
       inputPassword: "",      
     
        }
    },
    mounted()
    {

    },
    methods:
    {
        signIn: function()
      {
          if(this.inputEmail!="" && this.inputPassword != "")
          {
               const userLogin = 
                {
                    username: this.inputEmail,
                    password: this.inputPassword
                }

        console.log(userLogin);
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
                                        this.$router.push('HomePageAdmin/' + response.data.id);
                                        
                                    }
                                    else if(response.data.authorityRole === "ROLE_USERS")
                                    {
                                            this.$router.push('HomePageUser/'+ response.data.id);
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