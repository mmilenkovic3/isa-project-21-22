<template>
    <div>
        <div class="container-home">
  <div class="row">
    <div class="col-8 col-md-3">
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="infoFunction();"> Edit account </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="offersFunction();"> Show offers</button>
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
      <div v-if='this.offers' class="container-offers">
        <h1> OFFERS </h1>
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
      offers: false,
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
      inputRepeatPassword: ""
      
    }
  },
  
     methods:{              
     infoFunction: function()
        {
            this.info = true;
            this.offers = false;
            console.log("INFO");
        },
        offersFunction: function()
        {
            this.info = false;
            this.offers = true;
            console.log("OFFERS");
        },
        enabledFields: function()
        {
            this.disabledButtons = false;
            console.log(this.disabledButtons);
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

.container-offers
{
    background-color: red;
    
    margin-right: 10px;
}
</style>