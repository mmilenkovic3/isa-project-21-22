<template>
<div>
    <div>
        <h3> Reservations: </h3>
        <select v-model="type" id="type" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="type" style="font-size:22px; width: 50%; margin:0 auto;"                                         
                                          
                                    aria-describedby="addon-wrapping">
                                    
                                    <option  value="" > Selet entity to show... </option>
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="ADVENTURE"> Adventure </option>
        </select><hr> 
        <!-- search end -->
        <div class="container">
            <div class="row" v-show="type == 'COTTAGE'">                
               <!-- COTTAGE -->
                <div class="col">
                    <table v-for="cottageRes in client.actionReservationCottageDTOS" v-bind:key="cottageRes.reservation.id_reservation"
                    class = "table" style="border: 1px solid black;">
                        <tr>
                            <td> Reservation Date: </td>
                            <td> {{dateFormat(new Date(cottageRes.reservation.startDate), 0)}} - {{dateFormat(new Date(cottageRes.reservation.startDate), cottageRes.reservation.numDays*24)}} </td>
                        </tr>
                         <tr>
                            <td> Reservation type: </td>
                            <td> {{ cottageRes.reservation.reservationFastType }}</td>
                        </tr>
                        <tr>
                            <td> Cottage name: </td>
                            <td> <b>{{ cottageRes.cottage.name }}</b></td>
                        </tr>
                        <tr>
                            <td> Cottage grade: </td>
                            <td> {{ cottageRes.cottage.grade }}</td>
                        </tr>
                        <tr>
                            <td> Status reservation: </td>
                            <td>  {{ cottageRes.reservationCancelType }} </td>
                        </tr>
                         <tr v-if="cottageRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Cancel the reservation:  </td>
                            <td>  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;" v-on:click="cancelReservation(cottageRes.reservation.id_reservation,user_id )"> CANCEL </button> </td>
                        </tr>
                        <tr v-if="cottageRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Set your grade for this reservation: </td>
                            <td>  <input type = "text" class="form-control" v-model="cottageRes.reservation.grade"/>
                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;"
                                          v-on:click="setGrade(cottageRes.reservation.id_reservation,cottageRes.reservation.grade )"> Set grade </button> 
                             </td>
                        </tr>
                        
                    
                    </table>
                </div>
            </div>                
                <!-- COTTAGE END -->
                
                <div class="row"   v-show="type == 'BOAT'"> <!-- BOAT  -->
                    <div class="col">
                    <table v-for="boatRes in client.actionReservationBoatDTOS" v-bind:key="boatRes.reservation.id_reservation"
                    class = "table" style="border: 1px solid black;">
                        <tr>
                            <td> Reservation Date: </td>
                            <td> {{dateFormat(new Date(boatRes.reservation.startDate), 0)}} - {{dateFormat(new Date(boatRes.reservation.startDate), boatRes.reservation.numDays*24)}} </td>
                        </tr>
                         <tr>
                            <td> Reservation type: </td>
                            <td> {{ boatRes.reservation.reservationFastType }}</td>
                        </tr>
                        <tr>
                            <td> Cottage name: </td>
                            <td> <b>{{ boatRes.boat.name }}</b></td>
                        </tr>
                        <tr>
                            <td> Cottage grade: </td>
                            <td> {{ boatRes.boat.grade }}</td>
                        </tr>
                        <tr>
                            <td> Status reservation: </td>
                            <td>  {{ boatRes.reservationCancelType }} </td>
                        </tr>
                         <tr v-if="boatRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Cancel the reservation:  </td>
                            <td>  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;" v-on:click="cancelReservation(boatRes.reservation.id_reservation,user_id )"> CANCEL </button> </td>
                        </tr>
                        <tr v-if="boatRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Set your grade for this reservation: </td>
                            <td>  <input type = "text" class="form-control" v-model="boatRes.reservation.grade"/>
                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;"
                                          v-on:click="setGrade(boatRes.reservation.id_reservation,boatRes.reservation.grade )"> Set grade </button> 
                             </td>
                        </tr>
                        
                    
                    </table>
                </div>



                
                </div> <!-- BOAT  END -->
                <div class="row"  v-show="type == 'ADVENTURE'"><!-- ADVENTURE  -->

                <div class="col">
                    <table v-for="adveRes in client.actionReservationAdventureDTOS" v-bind:key="adveRes.reservation.id_reservation"
                    class = "table" style="border: 1px solid black;">
                        <tr>
                            <td> Reservation Date: </td>
                            <td> {{dateFormat(new Date(adveRes.reservation.startDate), 0)}} - {{dateFormat(new Date(adveRes.reservation.startDate), adveRes.reservation.numDays*24)}} </td>
                        </tr>
                         <tr>
                            <td> Reservation type: </td>
                            <td> {{ adveRes.reservation.reservationFastType }}</td>
                        </tr>
                        <tr>
                            <td> Cottage name: </td>
                            <td> <b>{{ adveRes.adventure.name }}</b></td>
                        </tr>
                        <tr>
                            <td> Cottage grade: </td>
                            <td> {{ adveRes.adventure.grade }}</td>
                        </tr>
                        <tr>
                            <td> Status reservation: </td>
                            <td>  {{ adveRes.reservationCancelType }} </td>
                        </tr>
                         <tr v-if="adveRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Cancel the reservation:  </td>
                            <td>  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;" v-on:click="cancelReservation(adveRes.reservation.id_reservation,user_id )"> CANCEL </button> </td>
                        </tr>
                        <tr v-if="adveRes.reservationCancelType == 'NOT_CANCEL'">
                            <td> Set your grade for this reservation: </td>
                            <td>  <input type = "text" class="form-control" v-model="adveRes.reservation.grade"/>
                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" 
                                          style="width:60% height:40px;"
                                          v-on:click="setGrade(adveRes.reservation.id_reservation,adveRes.reservation.grade )"> Set grade </button> 
                             </td>
                        </tr>
                        
                    
                    </table>
                </div>
                
                </div><!-- ADVENTURE END -->
            </div>
       









    </div>
</div>
</template>

<script>
export default{

    data()
    {
        return{
       
            user_id:  this.$route.params.id,
            client: [],
            type: "",
            cancelType: "",
        }
    },
    mounted()
    {
      this.getClient();
    
      
        
    },
    methods:
    {
        
        setGrade: function(id_reservation,grade )    
    {
       this.axios.post('/client/setGradeToReservation/'+id_reservation+'/'+grade, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {                         
                        console.log(response); 
                        
                        alert("Success!");
                        
                            this.getClient();   
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
    },
    cancelReservation: function(id_reservation,id_client)
    {
         this.axios.post('/client/cancelReservation/'+id_reservation+'/'+id_client, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {                         
                        console.log(response.data); 
                        alert("Successeffully canceled reservation.. ");
                        this.getClient();   
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
    },

       
    getClient: function()
      {
        this.axios.post('/client/getLoggedClient/'+this.user_id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {                     
                      
                        this.client = response.data;
                        console.log(this.client);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
      },
    dateFormat: function(date, numDays)
        {
            return this.subtractTimeFromDate(date,numDays).getDate()+"."+(this.subtractTimeFromDate(date,numDays).getMonth()+1)+"."+ this.subtractTimeFromDate(date,numDays).getFullYear();                
        },
    subtractTimeFromDate: function(objDate, intHours) {
            var numberOfMlSeconds = objDate.getTime();
            var addMlSeconds = (intHours * 60) * 60 * 1000;
            var newDateObj = new Date(numberOfMlSeconds + addMlSeconds);
            return newDateObj;
        },
        
      
      
     
    }

}
</script>
