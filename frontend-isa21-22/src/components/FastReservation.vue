<template>
<div>
    <h3> COTTAGE ACTION </h3> <br/>
    <div class="container">
  <div class="row">
    <div class="col-sm">
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
    <div class="col-sm">
      One of three columns
    </div>
    <div class="col-sm">
      One of three columns
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