<template>
<div>
<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  style="width:60% height:40px;
" v-on:click="$router.go(-1)"> Home page </button>
    <h3> ACTIONS: </h3> <br/>
 <!--<select v-model="reservationType" id="reservationType" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="reservationType" style="font-size:22px; width:70%; margin: 0 auto;"
                                          v-on:change="changeTypeSearch()"
                                    aria-describedby="addon-wrapping">
                                    <option  value="" > Search just... </option>
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="ADVENTURE"> Adventure </option>
                        </select>-->
   
    <div class="container" style="width: 180%;">
            <div class="row" >
                <div class="col" style="border: 1px black dotted;">
                        <h4> Cottage: </h4>
                        <p v-show="this.ActionsCottage.length == 0"> Action for cottage doesn't exists. </p>
                        <table class="table"
                        style="border: 1px solid black"
                         v-for="res in ActionsCottage" v-bind:key="res.action.id_action">
                                    <tr>
                                        <td> Action date:  </td>
                                        <td> {{res.action.startDate[2]}}.{{res.action.startDate[1]}}.{{res.action.startDate[0] }} - 
                                             {{res.action.endDate[2]}}.{{res.action.endDate[1]}}.{{res.action.endDate[0] }} </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Action price:  </td>
                                        <td> {{res.action.price }}e ------> {{res.action.priceWithDiscount}}e
                                             </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Cottage name:  </td>
                                        <td> {{ res.cottage.name }} </td>
                                    </tr>
                                     <tr>
                                        <td> Cottage address:  </td>
                                        <td> {{ res.cottage.address }} </td>
                                    </tr>
                                    <tr>
                                        <td> Grade:  </td>
                                        <td> {{ res.cottage.grade }} </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(res.reservation.id_reservation)"> Reserve </button>
                                        </td>
                                    </tr>
                        </table>                        
                </div> <!-- KRAJ COL ZA COTTAGE-->

        <!-- POCETAK COL ZA BOAT-->
               <div class="col" style="border: 1px black dotted;">
                        <h4> Boat: </h4>
                        <p v-show="this.ActionBoats.length == 0"> Action for boat doesn't exists. </p>
                        <table class="table"
                        style="border: 1px solid black"
                         v-for="res in ActionBoats" v-bind:key="res.action.id_action">
                                    <tr>
                                        <td> Action date:  </td>
                                        <td> {{res.action.startDate[2]}}.{{res.action.startDate[1]}}.{{res.action.startDate[0] }} - 
                                             {{res.action.endDate[2]}}.{{res.action.endDate[1]}}.{{res.action.endDate[0] }} </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Action price:  </td>
                                        <td> {{res.action.price }}e  {{res.action.priceWithDiscount}}e
                                             </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Cottage name:  </td>
                                        <td> {{ res.boat.name }} </td>
                                    </tr>
                                     <tr>
                                        <td> Cottage address:  </td>
                                        <td> {{ res.boat.address }} </td>
                                    </tr>
                                    <tr>
                                        <td> Grade:  </td>
                                        <td> {{ res.boat.grade }} </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(res.reservation.id_reservation)"> Reserve </button>
                                        </td>
                                    </tr>
                        </table>                        
                </div>
                 <!-- KRAJ COL ZA BOAT-->
                <!-- POCE COL ZA ADV-->
                 <div class="col" style="border: 1px black dotted;">
                        <h4> Adventure: </h4>
                        <p v-show="this.ActionAdventures.length == 0"> Action for adventure doesn't exists. </p>
                        <table class="table"
                        style="border: 1px solid black"
                         v-for="res in ActionAdventures" v-bind:key="res.action.id_action">
                                    <tr>
                                        <td> Action date:  </td>
                                        <td> {{res.action.startDate[2]}}.{{res.action.startDate[1]}}.{{res.action.startDate[0] }} - 
                                             {{res.action.endDate[2]}}.{{res.action.endDate[1]}}.{{res.action.endDate[0] }} </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Action price:  </td>
                                        <td> {{res.action.price }}e  {{res.action.priceWithDiscount}}e
                                             </td>
                                    </tr>
                                    
                                    <tr>
                                        <td> Adventure name:  </td>
                                        <td> {{ res.adventure.name }} </td>
                                    </tr>
                                     <tr>
                                        <td> Adventure address:  </td>
                                        <td> {{ res.adventure.address }} </td>
                                    </tr>
                                    <tr>
                                        <td> Grade:  </td>
                                        <td> {{ res.adventure.grade }} </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="reserve(res.reservation.id_reservation)"> Reserve </button>
                                        </td>
                                    </tr>
                        </table>                        
                </div><!-- kraj -->
                
            </div>
    </div>

</div>
</template>


<script>
export default{

    data()
    {
        return{
        ActionsCottage: [],    
        ActionBoats: [],
        ActionAdventures: [],       
        user_id: this.$route.params.id,
        reservationType: "",
     
        }
    },
    mounted()
    {
       this.getActions(); 
       this.getBoatActions();  
       this.getAdventure();
        
    },
    methods:
    {       
      getActions: function()
      {
        this.axios.post('/action/getAllAction/'+this.user_id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                       console.log("VIKENDICE"); 
                        this.ActionsCottage = response.data;
                        console.log(this.ActionsCottage);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
      },
       getBoatActions: function()
      {
        this.axios.post('/action/getAllBoatAction/'+this.user_id, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        this.ActionBoats = response.data;
                        console.log("BRODOVI");    
                        console.log(this.ActionBoats);    
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
      },
      getAdventure: function()
      {
        this.axios.post('/action/getAllAdventureAction/'+this.user_id, {
                            headers: 
                            {
                                'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                
                            }}).then(response => 
                            {                           
                                this.ActionAdventures = response.data;
                                console.log(this.ActionAdventures);    
                                event.preventDefault(); 

                            }).catch(res => {
                                console.log(res);                       
                                event.preventDefault();

                            });
      },
      reserve: function(id_reservation)
      {
            alert("Please wait a few minutes...");
            this.axios.post('/client/reservation/'+this.user_id+'/'+id_reservation,{
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {
                       
                        alert("Success!"); 
                        this.getActions();
                        this.getBoatActions();
                        this.getAdventure();
                        

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