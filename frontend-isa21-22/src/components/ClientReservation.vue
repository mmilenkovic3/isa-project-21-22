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
            <div class="row">
                <div class="col-sm"><!-- COTTAGE -->
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
                            <td> {{ reservationStatus(user_id, cottageRes.reservation.id_reservation )}}</td>
                        </tr>
                    
                    </table>
                

                </div> <!-- COTTAGE END -->
                <div class="col-sm"> <!-- BOAT  -->
                One of three columns
                </div> <!-- BOAT  END -->
                <div class="col-sm"><!-- ADVENTURE  -->
                One of three columns
                </div><!-- ADVENTURE END -->
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
       
            user_id:  this.$route.params.id,
            client: [],
            type: "",
        }
    },
    mounted()
    {
      this.getClient();
        
    },
    methods:
    {       
        reservationStatus: function(id, reservation_id)
    {
         this.axios.post('/client/reservationStatus/'+id +'/'+reservation_id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {                                           
                       var cancelType = response.data;  
                       console.log(cancelType) ;      
                       /*if(cancelType == "NOT_CANCEL")
                            return "NOT CANCEL" */              

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
        }
      
      
     
    }

}
</script>
