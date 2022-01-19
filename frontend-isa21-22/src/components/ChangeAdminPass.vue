<template>
    <div>    
    <div class="text" v-if="!this.user.accountEnabled" style="width:60%; margin: 0 auto;">
        <input type="password" v-model="oldPass" class="form-control" placeholder="old Password" required>
        <input type="password" v-model="pass" class="form-control" placeholder="New Password" required>
        <input type="password" v-model="newPass" class="form-control" placeholder="Repeat Password" required>
        <button  style="margin-top:20px; height: 50px;" v-on:click="newPasswordSave()" class="btn btn-lg btn-primary btn-block btn-signin"> Save password </button>
        <button  style="margin-top:20px; height: 50px;" v-on:click="goBakc()" class="btn btn-lg btn-primary btn-block btn-signin"> Home Page </button>
             
    </div>
       
    </div>  
</template>
<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


export default {
  data() {
    return {
      
      user: {},
      id : this.$route.params.id,
     
      newPass:"",
      oldPass:"",
      pass:"",
      
    }
  },
  
     methods:{ 
         goBakc: function()
         {
            this.$router.push('/');
         }   ,          
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
      changePass: function()
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
      },
      newPasswordSave: function()
        {
            const passwordChange = 
            {
                password: this.oldPass,
                newPassword: this.newPass,
                idUser:this.id
            }

            this.axios.post('user/changePassword', passwordChange,
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                        alert("Successeffully changed password!");
                        console.log(response);
                        this.pass = "";
                        this.newPass = "";
                        this.odlPass = "";
                        this.$router.push('/LoginPage');  

                    }).catch(res => {
                        console.log(res);
                         alert("Wrong password!");
                        alert(res.data);
                        event.preventDefault();

                    }); 
        },

      
   
},
mounted() {
    console.log(this.$route.params.id);
   
      this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                {
                    headers: 
                    {
                       
                    }}).then(response => 
                    {                        
                        console.log(response.data);
                        this.user = response.data;
                                              

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();
                    });  
    },
}

</script>

