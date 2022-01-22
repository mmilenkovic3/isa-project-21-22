<template>
<div>
    <div class="container-home">
    <div class="row">
        <div class="col-8 col-md-3">
          <button class="btn btn-lg btn-primary btn-block btn-signin" v-if="this.id == 1" type="submit" v-on:click="addNewAdmin();"> Add new admin </button>          
          <!--<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"> Prihodi po rezervaciji </button>-->
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="  $router.push('/AdminAnswerComplain/'+ id);"> Complains </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="  $router.push('/DeleteAccount/'+ id);"> Delete requests </button>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="reservationPage();"> Prihodi </button>
                 
      </div>
      <div class="col">
          <div v-if='this.info' class="container-info" style="background-color:white;">
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
            <div class="container" style="padding: 10px;">
                    <div class="row">
                        <div class="col-sm">
                        <hr>
                        <h3> Request for registration: </h3>

                            <table class="table">
  <thead>
    <tr>
      <th scope="col">Person</th>
      <th scope="col">Registration type</th>
      <th scope="col">Email</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>

    <tr v-for="user in this.requestUser" v-bind:key="user.id">
      <th scope="row">1</th>
      <td>{{user.name}} {{user.surname}}</td>
      <td>{{user.authorityRole}}</td>
      <td>{{user.email}}</td>
      <td><button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="approve(user.id)"> Approve </button></td>
       <td><button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="disapprove(user.id, disapproveText+user.id)"> Disapprove </button></td>
      <td><textarea v-model="disapproveText"  style="background-color:white; width: 100%;"      
       placeholder="Disapprove reson.."></textarea></td>
    </tr>
   
  </tbody>
</table>





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
      disapproveText: "",

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
      requestUser: [],

      
      
    }
  },
  
     methods:{ 
       disapprove: function(id, disapproveText)
       {
         if(this.disapproveText == "")
          alert("You need to add reason for disapprove!");
        else
        {
          console.log(disapproveText)
             this.axios.post('/admin/disapprove/'+id+'/'+ this.disapproveText, 
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                               
                        alert("User is disapproved and deleted!");
                        console.log(response.data);
                        this.getRequestForReg();

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();

                    }); 
        }
         
       }, approve: function(id)
       {
        this.axios.post('/admin/approve/'+id, 
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                               
                        alert("User is approved!");
                        console.log(response.data);
                        this.getRequestForReg();

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();

                    }); 
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
comp: function()
{
      this.$router.push('/AdminAnswerComplain/'+ this.id);
},
        loggedUser: function()
        {
            this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                            {
                                headers: 
                                {
                                
                                }}).then(response => 
                                {     
                                    console.log(response.data);            
                                    
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
            getRequestForReg: function()
            {
              this.axios.post('/admin/getRequest/',
                            {
                                headers: 
                                {
                                
                                }}).then(response => 
                                {   console.log("REQUESTS:");
                                    this.requestUser = response.data;  
                                    console.log(response.data);

                                }).catch(res => {

                                    console.log(res);
                                    event.preventDefault();
                                }); 
            }

      
   
},
mounted() {
    
    this.loggedUser();
    this.getRequestForReg();
}
}
</script>