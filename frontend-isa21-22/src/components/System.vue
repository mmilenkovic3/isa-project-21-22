<template>
<div class='slik' style="width: 100%;margin: 0px auto; height: 100%;display: block;position: absolute;margin-top: -60px; ">
    
    <div style="width: 70%; margin: 0px auto;position: initial;display: block;margin-top: 60px;">
    <h1> Welcome. You can see our services </h1>
    <h4>If you want to reserve some of our action, please sing up. </h4>
    <br>
        <!--<div style="margin: 0 auto; position: relative;">
            <img src="../assets/ban.jpg" height="200px" width="100%">
        </div>-->
        <div class="container">
            <div class="row">
                <div class="col-md">
                <button class="btn btn-lg btn-primary btn-block btn-signin"
                type="submit" 
                    v-on:click.prevent="signUp()"
                    > Sing up </button>
                </div>
                <div class="col-md">
                    <button class="btn btn-lg btn-primary btn-block btn-signin"
                    type="submit" 
                        v-on:click.prevent="signIn()"
                    > Sing in</button>
                
                </div>
            
            </div>
        </div>
<br> 
        <select v-model="type" id="type" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="type" style="font-size:22px; width: 50%; margin:0 auto;"                                         
                                          
                                    aria-describedby="addon-wrapping">
                                    
                                    <option  value="" > Selet entity to show... </option>
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="ADVENTURE"> Adventure </option>
        </select>
        <br> 
        <!-- COTTAGE -->
        <div v-show="this.type == 'COTTAGE'">
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
        <!-- BOAT -->
        <div v-show="this.type == 'BOAT'">
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
    </div>
</template>

<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



export default {
  data() {
    return {
        type: "",
        Cottages: [],
        Adventures: [],
        Boats: [],
    }
  },
  mounted() {
       this.getAllAdventure();
       this.getAllBoats();
       this.getAllCottage();

    },
     methods:
     {     
         signIn: function()
         {
              this.$router.push('/LoginPage');
         }   ,    
          signUp: function()
         {
              this.$router.push('/Registration');
         }   , 
         getAllCottage: function()
        { 
            
            this.axios.get('/cottage/findAll',
                {
                    headers: 
                    {
                        
                        
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
                        
                        
                    }}).then(response => 
                    {
                        this.Boats = response.data;
                        console.log(this.Boats);

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
                       
                        
                    }}).then(response => 
                    {
                        this.Adventures = response.data;
                        console.log(this.Adventures);

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        },  
        showMoreCottage: function(cottage_id)
        {
                console.log(cottage_id);
                this.$router.push('/CottageInfo/'+cottage_id); 
        },
        showMoreBoat: function(boat_id)
        {
            console.log(boat_id);
            this.$router.push('/BoatInfo/'+boat_id); 
        },
        
        showMoreAdventure: function(adventure_id)
        {
            console.log(adventure_id);
             this.$router.push('/AdventureInfo/'+adventure_id); 
        },
         
   
}
}

</script>

<style>
.slik{

    background-image: url('https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/248259760.jpg?k=72b5411819c0c4a858a17208a05407c4d1ede273b7990ef7c9b6ab170ce83baf&o=');
    background-size: 100% 150%;
    color: white;
    background-repeat: no-repeat;
     background-size: cover;
    background-attachment: fixed;
}

</style>