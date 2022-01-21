<template>
    <div>
        <div class="container-home">
  <div class="row">
    <div class="col-8 col-md-3">
    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="infoEntity();"> Info about cottage/adventure/boat </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="infoFunction();"> Edit account </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="cottagesFunction(); getAllCottage();"> Subscribe </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="changePass();"> Change password </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="reservationPage();"> Reservation </button>
      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="fasteResPage();"> Fast reservation </button>
       <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="logOut()"> Log out </button>
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
    <!-- delete acc -->
        <div>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="textForDelete = !textForDelete"> Delete Account </button>
            <div v-if="this.textForDelete">
                <br> 
                <p> Why you want to delete account? </p>
                <textarea v-model="messageDelete" style="background-color:white; width: 50%;" placeholder="add multiple lines"></textarea>
                <br>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="deleteAcc()"> OK </button>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" v-on:click="textForDelete = !textForDelete"> Cancel </button>
            </div>

        </div>
 <!-- delete end -->

      </div>

      <!-- SHOW ALL OFFER SECTIOn -->
      <div v-if='this.CottagesShow' class="container-Cottages">
        <h1> Cottages </h1>
        <div class="container">
            <div class="row"> 
                <div class="col-md"> <!--  Nije pretplacen -->
                
                                <h2> Not subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="checkIfIsSubscribe(cottage.id_cottage)"
                 v-for=" cottage in this.Cottages" v-bind:key="cottage.id_cottage">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-success btn-block " type="submit" v-on:click="subscribe(cottage.id_cottage)"> Subscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>

            
                </div>
                <div class="col-md"> <!-- pretplacen -->
                              <h2> Subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="checkIfIsUnSubscribe(cottage.id_cottage)"
                 v-for=" cottage in this.Cottages" v-bind:key="cottage.id_cottage">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ cottage.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-danger btn-block " type="submit" v-on:click="unsubscribe(cottage.id_cottage)"> Unsubscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>   
                </div>    
            </div>
        </div>
        <!-- Adventure -->
        <h1> Adventure </h1>
        <div class="container">
            <div class="row"> 
                <div class="col-md"> <!--  Nije pretplacen -->
                
                                <h2> Not subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="showAdventureSub(adventure.id_adventure)"
                 v-for=" adventure in this.Adventures" v-bind:key="adventure.id_adventure">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-success btn-block " type="submit" v-on:click="subscribeAdventure(adventure.id_adventure)"> Subscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>

            
                </div>
                <div class="col-md"> <!-- pretplacen -->
                              <h2> Subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="adventureUnSubscribe(adventure.id_adventure)"
                 v-for=" adventure in this.Adventures" v-bind:key="adventure.id_adventure">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ adventure.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-danger btn-block " type="submit" v-on:click="unsubscribeAdventure(adventure.id_adventure)"> Unsubscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>

               


                </div>    
            </div>
        </div>

        <!-- BOAT FOR SUB-->
        <h1> Boats: </h1>
        <div class="container">
            <div class="row"> 
                <div class="col-md"> <!--  Nije pretplacen -->
                
                                <h2> Not subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="showBoatSub(boat.id_boat)"
                 v-for=" boat in this.Boats" v-bind:key="boat.id_boat">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-success btn-block " type="submit" v-on:click="subscribeBoat(boat.id_boat)"> Subscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>

            
                </div>
                <div class="col-md"> <!-- pretplacen -->
                              <h2> Subscribe:  </h2>
                <table  style="border: 1px solid black; margin-bottom:10px; padding:10px;" class="table"
                v-show="boatUnSubscribe(boat.id_boat)"
                 v-for=" boat in this.Boats" v-bind:key="boat.id_boat">
                    <tbody >
                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Name:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.name }}
                            </td>
                        </tr>  

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Address:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.address }}
                            </td>
                        </tr> 

                        <tr style="border: 1px solid black; ">
                            <td style="border: 1px solid black; ">
                                Grade:
                            </td>
                            <td style="border: 1px solid black; ">
                                {{ boat.grade }}
                            </td>
                        </tr>  
                        <tr >
                        <td colspan="2"> <button class="btn btn-lg btn-danger btn-block " type="submit" v-on:click="unsubscribeBoat(boat.id_boat)"> Unsubscribe </button>
                        </td>
                        </tr> 
                    </tbody>
                </table>

               


                </div>    
            </div>
        </div>                 
      </div>

    <!-- CHANGE PASSWORD -->
      <div v-if='this.pass' class="container-pass">
        <h1> Change password: </h1>
        
        <input type="text"  v-model="password" class="form-control" placeholder="Password" required>
        <input type="text" v-model="newPassword" class="form-control" placeholder="New password" required>
        <input type="text" v-model="newPasswordRepeat" class="form-control" placeholder="Repeat new password" required>
       <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="newPasswordSave()"> Save password </button>
      </div>


    <!--   COTAGE/ ADVE / BOAT -->

         <div v-if='this.entityInfo' class="container-pass">
        <h2> Select waht information you want to see:  </h2>
        <select v-model="type" id="type" class="form-control" 
                                          
                                          :select="type" style="font-size:22px; width: 50%; margin:0 auto;"                                         
                                          
                                    aria-describedby="addon-wrapping">
                                    
                                    <option  value="" > Selet cottage/boat/adventure... </option>
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="ADVENTURE"> Adventure </option>
        </select>
       
      
      <!-- COTTAGE -->
        <div v-show="this.type == 'COTTAGE'">
    
            <div class="container">
            <div class="row">
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortName()"> Sort by Name </button>
                </div>
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortAddress()"> Sort by Address </button>
                </div>
                <div class="col-sm">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortGrade()"> Sort by Grade </button>
                </div>
            </div>
            <br>
        

            <div style=" width: 60%; margin:0 auto; margin-bottom:20px;" v-for="cottage in this.Cottages" v-bind:key="cottage.id_cottage">
                <div  class="form-control" style="font-size:22px;"> <b>  {{cottage.name}} </b></div>
                 <div class="form-control"> Address:  {{cottage.address}}</div>
                 <div  class="form-control"> Promo descritpion:  {{cottage.promoDescription}}</div>
                 <div  class="form-control"> Grade: {{cottage.grade}}</div>
                 <button class="btn btn-lg btn-primary btn-block btn-signin"
                    type="submit" 
                        v-on:click.prevent="showMoreCottage(cottage.id_cottage)"
                    > Show more... </button>
            </div>
        </div>

        </div>
        <!-- BOAT -->
        <div v-show="this.type == 'BOAT'">

        <div class="container">
            <div class="row">
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortName()"> Sort by Name </button>
                </div>
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortAddress()"> Sort by Address </button>
                </div>
                <div class="col-sm">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortGrade()"> Sort by Grade </button>
                </div>
            </div>
            <br>
            </div>



            <div style=" width: 60%; margin:0 auto; margin-bottom:20px;" v-for="boat in this.Boats" v-bind:key="boat.id_boat">
                <div  class="form-control" style="font-size:22px;"> <b>  {{boat.name}} </b></div>
                 <div class="form-control"> Address:  {{boat.address}}</div>
                 <div  class="form-control"> Promo descritpion:  {{boat.promoDescriptionBoat}}</div>
                 <div  class="form-control"> Grade: {{boat.grade}}</div>
                 <button class="btn btn-lg btn-primary btn-block btn-signin"
                    type="submit" 
                        v-on:click.prevent="showMoreBoat(boat.id_boat)"
                    > Show more... </button>
            </div>
        </div >

        <!-- ADVENTURE -->
        <div v-show="this.type == 'ADVENTURE'">
<div class="container">
            <div class="row">
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortName()"> Sort by Name </button>
                </div>
                <div class="col-sm">
               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortAddress()"> Sort by Address </button>
                </div>
                <div class="col-sm">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="sortGrade()"> Sort by Grade </button>
                </div>
            </div>
            <br>
            </div>
        
            <div style=" width: 60%; margin:0 auto; margin-bottom:20px;" v-for="a in this.Adventures" v-bind:key="a.id_adventure">
                    <div  class="form-control" style="font-size:22px;"> <b>  {{a.name}} </b></div>
                    <div class="form-control"> Address:  {{a.address}}</div>
                    <div  class="form-control"> Promo descritpion:  {{a.promoDescriptionAdventure}}</div>
                    <div  class="form-control"> Grade: {{a.grade}}</div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin"
                        type="submit" 
                            v-on:click.prevent="showMoreAdventure(a.id_adventure)"
                        > Show more... </button>
                </div>
        
        </div>

</div>
    <!-- End COTTAGE /ADVE/BOAT -->
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
        id: this.$route.params.id,
      info: false,
      entityInfo: true,
      Cottages: [],
      Boats: [],
      Adventures: [],
      CottagesShow: false,
      pass: false,
      disabledButtons: true,
      user: {},
      type: "",
      textForDelete: false,
      messageDelete: "",

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
      sortByNameAsc: true,
      sortByAddressAsc: true,
      sortByGradeAsc: true,
    }
  },
  
     methods:{  
         showMoreCottage: function(cottage_id)
        {                
                this.$router.push('/CottageInfo/'+cottage_id); 
        },
        showMoreBoat: function(boat_id)
        {
          
            this.$router.push('/BoatInfo/'+boat_id); 
        },
        
        showMoreAdventure: function(adventure_id)
        {
            
             this.$router.push('/AdventureInfo/'+adventure_id); 
        },
         logOut: function()
         {
            localStorage.removeItem('accessToken');
            this.$router.push('/');

         },
         deleteAcc: function()
         {
             this.axios.post('/deleteAcc/sendRequest/'+this.id+'/'+this.messageDelete, {
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                                    console.log(response.data);
                                    alert("Success!");
                                    this.textForDelete = !this.textForDelete;

                            }).catch(res => {
                                alert(res.response.data);  
                                this.textForDelete = !this.textForDelete;                     
                                event.preventDefault();

                            });

         },
         sortName: function()
         {
             if(this.type == 'COTTAGE')
             {
                  if(this.sortByNameAsc){
                        
                        this.sortByNameAsc = false;
                        this.axios.post('/cottage/sortByNameAsc',this.Cottages,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Cottages = response.data;   
                                

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });
                    }else
                    {
                        this.sortByNameAsc = true;

                        this.axios.post('/cottage/sortByNameDesc',this.Cottages,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Cottages = response.data;   
                                

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });

                    }
             }
              else if(this.type == 'BOAT')
             {
                if(this.sortByNameAsc){
                        
                        this.sortByNameAsc = false;
                        this.axios.post('/boat/sortByNameAsc',this.Boats,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Boats = response.data;   
                                

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });
                    }else
                    {
                        this.sortByNameAsc = true;

                        this.axios.post('/boat/sortByNameDesc',this.Boats,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Boats = response.data;                                   

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });

                    }

             } else if(this.type == 'ADVENTURE')
             {
                if(this.sortByNameAsc){
                        
                        this.sortByNameAsc = false;
                        this.axios.post('/adventure/sortByNameAsc',this.Adventures,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Adventures = response.data;   
                                

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });
                    }else
                    {
                        this.sortByNameAsc = true;

                        this.axios.post('/adventure/sortByNameDesc',this.Adventures,{
                                headers: 
                                {
                                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {
                                this.Adventures = response.data;   
                                

                                }).catch(res => {
                                    console.log(res);                       
                                    event.preventDefault();

                                });

                    }

             }

         },
         sortAddress: function()
         {
                 if(this.type == 'COTTAGE')
             {
                 if(this.sortByAddress){
                            
                            this.sortByAddress = false;
                            this.axios.post('/cottage/sortByAddressAsc',this.Cottages,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Cottages = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });
                        }else
                        {
                            this.sortByAddress = true;

                            this.axios.post('/cottage/sortByAddressDesc',this.Cottages,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Cottages = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });

                        }
             }
              else if(this.type == 'BOAT')
             {
                if(this.sortByAddress){
                            
                            this.sortByAddress = false;
                            this.axios.post('/boat/sortByAddressAsc',this.Boats,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Boats = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });
                        }else
                        {
                            this.sortByAddress = true;

                            this.axios.post('/boat/sortByAddressDesc',this.Boats,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Boats = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });

                        }

             } else if(this.type == 'ADVENTURE')
             {
                if(this.sortByAddress){
                            
                            this.sortByAddress = false;
                            this.axios.post('/adventure/sortByAddressAsc',this.Adventures,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Adventures = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });
                        }else
                        {
                            this.sortByAddress = true;

                            this.axios.post('/adventure/sortByAddressDesc',this.Adventures,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.Adventures = response.data;   
                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });

                        }

             }
         },
         sortGrade: function()
         {
             if(this.type == 'COTTAGE')
             {
                     if(this.sortByGrade){
                    
                    this.sortByGrade = false;
                    this.axios.post('/cottage/sortByGradeAsc',this.Cottages,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Cottages = response.data;   
                            

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();

                            });
                }else
                {
                    this.sortByGrade = true;

                    this.axios.post('/cottage/sortByGradeDesc',this.Cottages,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Cottages = response.data;   
                            

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();

                            });

         }
             }
              else if(this.type == 'BOAT')
             {
                    if(this.sortByGrade){
                    
                    this.sortByGrade = false;
                    this.axios.post('/boat/sortByGradeAsc',this.Boats,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Boats = response.data;   
                            

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();

                            });
                }else
                {
                    this.sortByGrade = true;

                    this.axios.post('/boat/sortByGradeDesc',this.Boats,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Boats = response.data;   
                            

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();

                            });
                    }
             } else if(this.type == 'ADVENTURE')
             {
                 if(this.sortByGrade){
                    
                    this.sortByGrade = false;
                    this.axios.post('/adventure/sortByGradeAsc',this.Adventures,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Adventures = response.data;                              

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();
                            });
                }else
                {
                    this.sortByGrade = true;
                    this.axios.post('/adventure/sortByGradeDesc',this.Adventures,{
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {
                            this.Adventures = response.data;                           

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();
                            });
                  }
             }
         },
         
        showBoatSub: function(id_boat)
        {
            for(var sub in this.user.boatClientSubscribe)
                {
                     if(this.user.boatClientSubscribe[sub].id_boat == id_boat)
                    {
                        return false;
                    }
                }
                return true;
        },
        showAdventureSub: function(id_adventure)
        {
                for(var sub in this.user.adventureClientSubscribe)
                {
                     if(this.user.adventureClientSubscribe[sub].id_adventure == id_adventure)
                    {
                        return false;
                    }
                }
                return true;
        },
         checkIfIsSubscribe: function(id_cottage)
         {
                
                for(var sub in this.user.cottageClientSubscribes)
                {
                     if(this.user.cottageClientSubscribes[sub].id_cottage == id_cottage)
                    {
                        return false;
                    }
                }
                return true;
         }          
         ,
          checkIfIsUnSubscribe: function(id_cottage)
         {
                
                for(var sub in this.user.cottageClientSubscribes)
                {
                    if(this.user.cottageClientSubscribes[sub].id_cottage == id_cottage)
                    {
                        return true;
                    }
                }
                return false;

         } ,
         boatUnSubscribe: function(id_boat)
         {
                
                for(var sub in this.user.boatClientSubscribe)
                {
                    if(this.user.boatClientSubscribe[sub].id_boat == id_boat)
                    {
                        return true;
                    }
                }
                return false;

         } ,
          adventureUnSubscribe: function(id_adventure)
         {
                
                for(var sub in this.user.adventureClientSubscribe)
                {
                    if(this.user.adventureClientSubscribe[sub].id_adventure == id_adventure)
                    {
                        return true;
                    }
                }
                return false;

         } ,
         unsubscribe: function(id_cottage)
         {
           

            this.axios.post('/client/unsubscribeCottage/'+id_cottage+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.user = response.data;
                        this.getAllCottage(); 

                    }).catch(res => {
                        console.log(res);  
                        this.getAllCottage();                      
                        event.preventDefault();

                    });
         },
         unsubscribeBoat: function(id_boat)
         {            

            this.axios.post('/client/unsubscribeBoat/'+id_boat+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.user = response.data;
                        this.getAllBoats(); 

                    }).catch(res => {
                        console.log(res);  
                        this.getAllBoats();                      
                        event.preventDefault();

                    });
         },
          unsubscribeAdventure: function(id_adventure)
         {
            this.axios.post('/client/unsubscribeAdventure/'+id_adventure+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.user = response.data;
                        this.getAllAdventures(); 

                    }).catch(res => {
                        console.log(res);  
                        this.getAllAdventure();                      
                        event.preventDefault();

                    });
         },
         subscribe: function(id_cottage)
         {
              this.axios.post('/client/subscribeCottage/'+id_cottage+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       this.user = response.data;
                        this.getAllCottage();
                        

                    }).catch(res => {
                        console.log(res);  
                        this.getAllCottage();                       
                        event.preventDefault();

                    });
         },
         subscribeBoat: function(id_boat)
         {            
              this.axios.post('/client/subscribeBoat/'+id_boat+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       this.user = response.data;
                        this.getAllBoats();
                        

                    }).catch(res => {
                        console.log(res);  
                        this.getAllBoats();                       
                        event.preventDefault();

                    });
         },
         subscribeAdventure: function(id_adventure)
         {
              this.axios.post('/client/subscribeAdventure/'+id_adventure+'/'+this.id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       this.user = response.data;
                        this.getAllAdventures();
                        

                    }).catch(res => {
                        console.log(res);  
                        this.getAllAdventure();                       
                        event.preventDefault();

                    });
         },

         fasteResPage: function()
         {
              this.$router.push('/FastReservation/'+ this.$route.params.id);
         },
         reservationPage: function()
         {
              this.$router.push('/Reservations/'+ this.$route.params.id);
         },           
     infoFunction: function()
        {
            this.info = true;
            this.CottagesShow = false;
            this.pass = false;
            this.entityInfo = false;
        },
        infoEntity: function()
         {
                this.info = false;
            this.CottagesShow = false;
            this.pass = false;
            this.entityInfo = true;
         },
        cottagesFunction: function()
        {
            this.info = false;
            this.CottagesShow = true;
            this.pass = false;
        },
        enabledFields: function()
        {
            this.disabledButtons = false;
        },
        changePass: function()
        {
            this.info = false;
            this.CottagesShow = false;
            this.entityInfo = false;
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
            const user =    {
                                name : this.inputName,
                                surname : this.inputSurName,
                                email : this.inputEmail,                                            
                                address : this.inputAddress,
                                phoneNumber : this.inputPhoneNum,
                                city : this.inputCity,
                                country : this.inputCountry
                            }  
                
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
            this.axios.get('/cottage/findAll',
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.Cottages = response.data;
                        console.log(this.Cottages);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        },
        getAllBoats: function()
        {             
            this.axios.get('/boat/findAll',
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.Boats = response.data;
                       

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        },

        getAllAdventure: function()
        { 
               this.axios.get('/adventure/findAll',
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.Adventures = response.data;
                       

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        },
        loggedUser: function()
        {
            this.axios.post('/user/getUserByID/'+ this.$route.params.id,
                            {
                                headers: 
                                {
                                
                                }}).then(response => 
                                {               
                                    
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
                    }

      
   
},
mounted() {
        this.loggedUser();
        this.getAllBoats();
        this.getAllAdventure();
     
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
    margin-right: 10px;
}
</style>