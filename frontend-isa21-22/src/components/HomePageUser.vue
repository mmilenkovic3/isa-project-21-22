<template>
    <div>
        <div class="container-home">
  <div class="row">
    <div class="col-8 col-md-3">
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="infoFunction();"> Edit account </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="cottagesFunction(); getAllCottage();"> Cottages </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="changePass();"> Change password </button>
    </div>
    <div class="col">
      <div v-if='this.info' class="container-info">
        <h1> User info: </h1>
        <input type="text"  v-model="inputName" class="form-control" placeholder="Name" :disabled='this.disabledButtons' required>
                <input type="text" v-model="inputSurName" class="form-control" placeholder="Surname" :disabled='this.disabledButtons' required>
               <input type="text" v-model="inputAddress" class="form-control" placeholder="Address" :disabled ='this.disabledButtons' required>
               <input type="text" v-model="inputPhoneNum" class="form-control" placeholder="Phone number" :disabled='this.disabledButtons' required>
               <input type="text" v-model="inputCity" class="form-control" placeholder="City" :disabled='this.disabledButtons' required>
               <input type="text" v-model="inputCountry" class="form-control" placeholder="Country" :disabled='this.disabledButtons' required>
               <input type="email" v-model="inputEmail" class="form-control" placeholder="Email address" disabled='true' required >
                
                <div class="container" style="padding: 10px;">
                    <div class="row">
                        <div class="col-sm">
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="enabledFields()" :disabled='!this.disabledButtons'> Change </button>
                        </div>
                        <div class="col-sm">
                       <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" :disabled='this.disabledButtons' v-on:click="saveEdit()"> Save </button>
                        </div>
                        <div class="col-sm">
                       <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" :disabled='this.disabledButtons' v-on:click="cancelEdit()"> Cancel </button>
                        </div>
                    </div>
                    </div>
    <h2> penality </h2>
    <h2> loyaliti program </h2>
      </div>

      <!-- SHOW ALL OFFER SECTIOn -->
      <div v-if='this.Cottages' class="container-Cottages">
        <h1> Cottages </h1>
                 
      </div>

    <!-- CHANGE PASSWORD -->
      <div v-if='this.pass' class="container-pass">
        <h1> Change password: </h1>
        
        <input type="text"  v-model="password" class="form-control" placeholder="Password" required>
        <input type="text" v-model="newPassword" class="form-control" placeholder="New password" required>
        <input type="text" v-model="newPasswordRepeat" class="form-control" placeholder="Repeat new password" required>
       <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="newPasswordSave()"> Save password </button>
      </div>
    </div>
    
  </div>
</div>


    </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  data() {
    return {
      info: true,
      Cottages: false,
      pass: false,
      disabledButtons: true,
      user: {},

      inputName: "",
      inputSurName: "",
      inputAddress: "",
      inputPhoneNum: "",
      inputCity: "",
      inputCountry: "",
      inputEmail: "",
      inputPassword: "",
      inputRepeatPassword: "",


      password: "",
      newPassword: "",
      newPasswordRepeat: "",

      allCotages: [],
      
    }
  },
  
     methods:{              
     infoFunction: function()
        {
            this.info = true;
            this.Cottages = false;
            this.pass = false;
            console.log("INFO");
        },
        cottagesFunction: function()
        {
            this.info = false;
            this.Cottages = true;
            this.pass = false;
            console.log("Cottages");
        },
        enabledFields: function()
        {
            this.disabledButtons = false;
            console.log(this.disabledButtons);
        },
        changePass: function()
        {
            this.info = false;
            this.Cottages = false;
            this.pass = true;
        },
        cancelEdit: function()
        {
            this.disabledButtons = true;                     
            this.inputName = this.user.name;
            this.inputSurName = this.user.surname;
            this.inputEmail = this.user.email;
            this.inputAddress = this.user.address;
            this.inputCity = this.user.city;
            this.inputCountry = this.user.country;
            this.inputPhoneNum = this.user.phoneNumber;

        },
        saveEdit: function()
        {
            const user = 
                            {
                                name : this.inputName,
                                surname : this.inputSurName,
                                email : this.inputEmail,                                            
                                address : this.inputAddress,
                                phoneNumber : this.inputPhoneNum,
                                city : this.inputCity,
                                country : this.inputCountry
                            }  

                    console.log(user); 
                
                this.axios.post('user/editUser', user,
                {
                    headers: 
                    {
                        //'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                            this.inputName = response.data.name;
                            this.inputSurName = response.data.surname;
                            this.inputAddress = response.data.address;
                            this.inputCity = response.data.city;
                            this.inputCountry = response.data.country;
                            this.inputPhoneNum = response.data.phoneNumber;
                            this.disabledButtons = true;   

                    }).catch(res => {
                        console.log(res);
                        alert("User with this email already existas!");
                        event.preventDefault();

                    });     
        },
        newPasswordSave: function()
        {
            const passwordChange = 
            {
                password: this.password,
                newPassword: this.newPassword
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
                        this.password = "";
                        this.newPasswordRepeat = "";
                        this.newPassword = "";
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);
                        alert(res.data);
                        event.preventDefault();

                    }); 
        },
        getAllCottage: function()
        { 
            console.log("Token: " + localStorage.getItem('accessToken'));
            this.axios.get('/cottage/findAll',
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.allCotages = response.data;
                        console.log(this.allCotages);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        }

      
   
},
mounted() {
    
    this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                {
                    headers: 
                    {
                       
                    }}).then(response => 
                    {                        
                        console.log(response);
                        this.user = response.data;                      
                        this.inputName = this.user.name;
                        this.inputSurName = this.user.surname;
                        this.inputEmail = this.user.email;
                        this.inputAddress = this.user.address;
                        this.inputCity = this.user.city;
                        this.inputCountry = this.user.country;
                        this.inputPhoneNum = this.user.phoneNumber;

                        this.getAllCottage();

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();
                    });  
    },
}

</script>
<style>
.container-info{  
    
    margin-right: 10px;
    padding: 10px;
    background: rgb(124, 207, 133);
}
.container-home
{
    margin-left:10px;
    height: 100%;
    
}
.container-pass
{
    margin-right: 10px;
    padding: 10px;
}

.container-Cottages
{
    background-color: red;
    
    margin-right: 10px;
}
</style>