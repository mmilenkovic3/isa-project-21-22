<template>
<div>
    <div class="container-home">
    <div class="row">
        <div class="col-8 col-md-3">
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="addNewAdmin();"> Add new admin </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="infoFunction();"> Request for delete </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"> Prihodi po rezervaciji </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="changePass();"> Procenat </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="reservationPage();"> Prihodi </button>
                 
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
                </div>


      </div>

      <!--col end-->
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
      id: this.$route.params.id,

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

      
      
    }
  },
  
     methods:{ 
       
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

        }     
        ,
        enabledFields: function()
        {
            this.disabledButtons = false;
            console.log(this.disabledButtons);
        },       
        addNewAdmin: function()
        {
          this.$router.push('/AddNewAdmins');
        } ,
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
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
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
        }
,
        loggedUser: function()
        {
            this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                            {
                                headers: 
                                {
                                
                                }}).then(response => 
                                {   console.log("USER");  
                                    console.log(response.data);            
                                    
                                    this.user = response.data;     
                                    console.log("THIS.USER");  
                                    console.log(this.user); 
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
                    }

      
   
},
mounted() {
    
    this.loggedUser();
}
}
</script>