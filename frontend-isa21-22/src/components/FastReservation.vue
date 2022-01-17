<template>
<div>
    <h3> COTTAGE ACTION </h3> <br/>
    <h6 v-if="this.Cottages.length == 0"> Action for cottages doesnt exists </h6>
    <div class="container">
  <div class="row">
    
      <div v-for="cottage in this.Cottages" v-bind:key="cottage.id_cottage">
        <p>
            {{cottage.name}}
        </p>
        <p>
            {{cottage.address}}
        </p>
        <!-- Action for that cottage reservation -->
        <div v-for="res in cottage.reservations" v-bind:key="res.id_reservation">
            <p v-show="res.reservationFastType =='ACTION'"> {{ new Date(res.startDate)}} - {{ res.startTime }} </p>
            <p v-show="res.reservationFastType =='ACTION'"> Number days: {{ res.numDays }} </p>
            <p v-show="res.reservationFastType =='ACTION'"> Price: {{ res.price }} </p>
            <button v-show="res.reservationFastType =='ACTION'" class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(res.id_reservation)"> Reserve </button>
        </div>           
      
      </div>
      </div>
    
    <h3> BOAT ACTION </h3> <br/>
    <h6 v-if="this.Boats.length == 0"> Action for boat doesnt exists </h6>
    <div class="container">
    <div class="row">    
      <div v-for="boat in this.Boats" v-bind:key="boat.id_boat" style="border: 1px solid; width: 500px; margin:0 auto;">
        <p>
        <div class="row">
            <div class="col" >
            Boat name:
            </div>
            <div class="col">
                {{boat.name}}
                </div>
          </div>
          <hr> 
          <div class="row">
            <div class="col" >
            Address:
            </div>
            <div class="col">
                {{boat.address}}
                </div>
          </div>
          <hr>           
            <p> RESERVATION: </p>
             <hr>
        <!-- Action for that cottage reservation -->
        <div v-for="aa in boat.reservationsBoat" v-bind:key="aa.id_reservation" v-show="aa.reservationFastType =='ACTION'">
             <div class="row">
                 <div class="col" >
                        Start date:
                 </div>
                 <div class="col">
                         {{ new Date(aa.startDate)}}
                 </div>
            </div>
             <div class="row">
                 <div class="col" >
                        Start time:
                 </div>
                 <div class="col">
                          {{ aa.startTime }}
                 </div>
            </div>
             
             <div class="row">
                 <div class="col" >
                        Number days:
                 </div>
                 <div class="col">
                         {{aa.numDays}}
                 </div>
            </div>

            

            <div class="row">
                 <div class="col" >
                        Price:
                 </div>
                 <div class="col">
                        {{ aa.price }} e
                 </div>
            </div>
            <br>
            <div class="row">
                <button  class="btn btn-lg btn-primary btn-block btn-signin" style="width:500px; margin: 0 auto;" type="submit"  v-on:click="reserve(aa.id_reservation)"> Reserve </button> 
            </div>


            <hr>
             
       </div>
     </div>  
    
  </div>
  </div>
  
  
  <h3> ADVENTURE ACTION </h3> <br/>
    <h6 v-if="this.Adventures.length == 0"> Action for Adventures doesnt exists </h6>
      <div class="container">
    <div class="row">    
      <div v-for="adventure in this.Adventures" v-bind:key="adventure.id_adventure" style="border: 1px solid; width: 500px; margin:0 auto;">
        <p>
        <div class="row">
            <div class="col" >
            Adventure name:
            </div>
            <div class="col">
                {{adventure.name}}
                </div>
          </div>
          <hr> 
          <div class="row">
            <div class="col" >
            Address:
            </div>
            <div class="col">
                {{adventure.address}}
                </div>
          </div>
          <hr>           
            <p> RESERVATION: </p>
             <hr>
        <!-- Action for that cottage reservation -->
        <div v-for="aa in adventure.reservationsAdventure" v-bind:key="aa.id_reservation" v-show="aa.reservationFastType =='ACTION'">
             <div class="row">
                 <div class="col" >
                        Start date:
                 </div>
                 <div class="col">
                         {{ new Date(aa.startDate)}}
                 </div>
            </div>
             <div class="row">
                 <div class="col" >
                        Start time:
                 </div>
                 <div class="col">
                          {{ aa.startTime }}
                 </div>
            </div>
             
             <div class="row">
                 <div class="col" >
                        Number days:
                 </div>
                 <div class="col">
                         {{aa.numDays}}
                 </div>
            </div>

            

            <div class="row">
                 <div class="col" >
                        Price:
                 </div>
                 <div class="col">
                        {{ aa.price }} e
                 </div>
            </div>
            <br>
            <div class="row">
                <button  class="btn btn-lg btn-primary btn-block btn-signin" style="width:500px; margin: 0 auto;" type="submit"  v-on:click="reserve(aa.id_reservation)"> Reserve </button> 
            </div>


            <hr>
             
       </div>
     </div>  
     </div> 
  </div>



</div>

</div>
</template>


<script>
export default{

    data()
    {
        return{
        Cottages: [],
        Boats: [],
        Adventures: [],    
        user_id: this.$route.params.id,
     
        }
    },
    mounted()
    {
       this.actionAdventure();
       this.actionCottages();
       this.actionBoats();
                    
                   
        
    },
    methods:
    {
        actionCottages: function()
      {
            this.axios.post('/cottage/cottageSearchForReservationAction', {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        this.Cottages = response.data;
                        console.log(this.Cottages);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
      },

      actionBoats: function()
      {
           this.axios.post('/boat/boateSearchForReservationAction', {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        this.Boats = response.data;
                        console.log("BOAT");   
                        console.log(this.Boats);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
      },

      actionAdventure: function()
      {
           this.axios.post('/adventure/adventureSearchForReservationAction', {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        this.Adventures = response.data;
                        console.log(this.Adventures);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
      },
      reserve: function(id_reservation)
      {
            this.axios.post('/client/reservation/'+this.user_id+'/'+id_reservation,{
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        alert("Success!"); 
                        this.actionBoats();
                        this.actionCottages();
                        this.actionAdventure();

                         console.log(response.data); 
                                     
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });

      }
    }

}
</script>