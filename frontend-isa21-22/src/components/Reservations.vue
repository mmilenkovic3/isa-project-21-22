<template>
<div>
    <h2> Reservation: </h2>
    <select v-model="reservationType" id="reservationType" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="reservationType" style="font-size:22px;"
                                    aria-describedby="addon-wrapping">
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="INSTRUCTOR"> Instructor </option>
                        </select>
    <input type="date"  v-model="date" class="form-control" placeholder="Date of reservation" required>
    <input type="time" v-model="time" class="form-control" placeholder="Time" >
    <input type="text" v-model="numDays" class="form-control" placeholder="Number of days">
    <h4>Addition for serach: </h4>
    <input type="text" v-model="address" class="form-control" placeholder="Address" >
    <input type="text" v-model="grade" class="form-control" placeholder="Grade" >
    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="getFreeReservation()"> Search reservation </button>
    <hr>
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
    </div>
    <hr/>
    <!-- COTTAGE SHOW FOR RESERVATION --> 
    <div v-show="this.reservationType === 'COTTAGE'">
        <div v-for="a in this.Cottages" v-bind:key="a.id_cottage" style="background-color:orange;">
        <table>
        <tr>
            <td> <p> Cottage name: </p> </td>
            <td> <p> {{a.name}} </p></td>
        </tr>
        <tr>
            <td> <p> Cottage info: </p> </td>
            <td> <p> {{ a.info }} </p> </td>
        </tr>
        <tr>
            <td> <p> Cottage grade: </p> </td>
            <td> <p> {{ a.grade }} </p> </td>
        </tr>
        <tr>
            <td> <p> Cottage reservation price: </p> </td>
            <td> <p> {{ showPriceCottage(a)}} e </p> </td>
        </tr>
        <tr>
            <td> <p> Address: </p> </td>
            <td> <p> {{  a.address }} </p> </td>
        </tr>
        <tr>
            <td> <p> Number of bed: </p> </td>
            <td> <p> {{  a.numBed }} </p> </td>
        </tr>
        <tr>
            <td> <p>Promo description: </p> </td>
            <td> <p> {{  a.promoDescription }} </p> </td>
        </tr>   
        </table>     
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(a)"> Reserve </button>
        </div>
    </div>
    
    <!-- BOAT SHOW FOR RESERVATION --> 
    <div v-show="this.reservationType === 'BOAT'">
        <div v-for="a in this.Boats" v-bind:key="a.id_boat" style="background-color:orange;">
        <table>
        <tr>
            <td> <p> Boat name: </p> </td>
            <td> <p> {{a.name}} </p></td>
        </tr>
        <tr>
            <td> <p> Boat max speed: </p> </td>
            <td> <p> {{ a.maxSpeed }} km/h </p> </td>
        </tr>
        <tr>
            <td> <p> Boat grade: </p> </td>
            <td> <p> {{ a.grade }} </p> </td>
        </tr>
        <tr>
            <td> <p> Boat reservation price: </p> </td>
            <td> <p> {{ showPriceBoat(a)}} e </p> </td>
        </tr>
        <tr>
            <td> <p> Address: </p> </td>
            <td> <p> {{  a.address }} </p> </td>
        </tr>
        <tr>
            <td> <p> Capacity: </p> </td>
            <td> <p> {{  a.capacity }} </p> </td>
        </tr>
        <tr>
            <td> <p>Promo description: </p> </td>
            <td> <p> {{  a.promoDescriptionBoat }} </p> </td>
        </tr>   
        </table>     
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(a)"> Reserve </button>
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
      Cottages: [],
      Boats: [],
      reservationType: "",
      date: "",
      time: "",
      numDays: "",
      address: "",
      grade: "",

      price: 0,
      dateToShow: "",
      numberDays: "",

      sortByNameAsc: true,
      sortByAddress: true,
      sortByGrade: true,
      
      
    }
  },
  computed:
  {
    
  },
  
     methods:{       
           showPriceCottage: function(cottage)
        {           
            for (var r in cottage.reservations)
            { 
                var dateFront = new Date(this.date);
                var dateRes = new Date(cottage.reservations[r].startDate)
                
                if(dateFront.getDate() === dateRes.getDate() && cottage.reservations[r].reservationStatus == "FREE" && cottage.reservations[r].reservationType == "COTTAGE")
                { 
                    return cottage.reservations[r].price;                  
                }
            }
            return 0;
        }, 
        showPriceBoat: function(boat)
        {           
            for (var r in boat.reservationsBoat)
            { 
                var dateFront = new Date(this.date);
                var dateRes = new Date(boat.reservationsBoat[r].startDate)
                
                if(dateFront.getDate() === dateRes.getDate() && boat.reservationsBoat[r].reservationStatus == "FREE" && boat.reservationsBoat[r].reservationType == "BOAT")
                { 
                    return boat.reservationsBoat[r].price;                  
                }
            }
            return 0;
        }, 
        getFreeReservation: function()
        {
            const infoRes = 
            {
                date: this.date,
                time: this.time,
                numDays: this.numDays,
                address: this.address,
                grade: this.grade,

            }  
            if(this.reservationType == "COTTAGE")
            {
                this.Cottages = [];              
           
            this.axios.post('/cottage/cottageSearchForReservation', infoRes,{
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
            }else if(this.reservationType =="BOAT")
            {
            this.Boats = [];              
           
            this.axios.post('/boat/boatSearchForReservation', infoRes,{
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                        this.Boats = response.data;
                        console.log(this.Boats);                 
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
            }
            else if(this.reservationType == "INSTRUCTOR")
            {
                    console.log(this.reservationType);      
            }
            
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
                        this.Cottages = response.data;
                        console.log(this.Cottages);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        },
        dateCompare: function(d1, d2) {
                const date1 = new Date(d1);
                const date2 = new Date(d2);

                if(date1 > date2){
                    console.log(`${d1} is greater than ${d2}`)
                } else if(date1 < date2){
                    console.log(`${d2} is greater than ${d1}`)
                } else{
                    return true;
                }
},
    sortName: function()

    {
        if(this.reservationType == "COTTAGE")
        {
            console.log("SORT");
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
        }else if(this.reservationType == "BOAT")
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
        }else if(this.reservationType == "INSTRUCTOR")
        {
            console.log("BOAT");
        }
        
    },

      sortAddress: function()
    {
        if(this.reservationType == "COTTAGE")
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
        }else if(this.reservationType == "BOAT")
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
        }else if(this.reservationType == "INSTRUCTOR")
        {
            console.log("BOAT");
        }
        
    },  sortGrade: function()
    {
        if(this.reservationType == "COTTAGE")
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
        }else if(this.reservationType == "BOAT")
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
        }
        else if(this.reservationType == "INSTRUCTOR")
        {
            console.log("BOAT");
        }
        
    },
    

    reserve: function(cottage)
    {
        var reservation_id = "";
        for (var r in cottage.reservations)
            { 
                var dateFront = new Date(this.date);
                var dateRes = new Date(cottage.reservations[r].startDate)
                
                if(dateFront.getDate() === dateRes.getDate() && cottage.reservations[r].reservationStatus == "FREE" && cottage.reservations[r].reservationType == "COTTAGE")
                { 
                    reservation_id = cottage.reservations[r].id_reservation;                  
                }
            }


        this.axios.post('/client/reservation/'+this.id+'/'+reservation_id,{
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        alert(response.date);                 
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
          
    }
      
   
},
mounted() {
        
        //this.getAllCottage();

    
    },
}

</script>