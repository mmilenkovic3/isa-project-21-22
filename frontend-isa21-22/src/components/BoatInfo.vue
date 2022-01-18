<template>
<div style="margin: 0 auto; width: 60%;">
    <h1> {{ this.Boat.name}} </h1>
    <table class="table">        
        <tr>
            <td> Address: </td>
            <td> {{this.Boat.address}}</td>
        </tr>
        <tr>
            <td> Grade: </td>
            <td> {{this.Boat.grade}}</td>
        </tr>
         <tr>
            <td> Engine power: </td>
            <td> {{this.Boat.enginePower}}</td>
        </tr>
         <tr>
            <td> Engine number: </td>
            <td> {{this.Boat.engingeNum}}</td>
        </tr>
        <tr>
            <td> Length: </td>
            <td> {{this.Boat.length}} m</td>
        </tr>

        <tr>
            <td> Fishing kig: </td>
            <td> 
                <tr v-for="f in this.Boat.fishingKits" v-bind:key="f.id_fishing_kit" >
                     {{ f.name }}                    
                </tr>
            </td>
        </tr>
         <tr>
            <td> Price: </td>
            <td> {{this.Boat.price}} e</td>
        </tr>
         <tr>
            <td> Promo description: </td>
            <td> {{this.Boat.promoDescriptionBoat}}</td>
        </tr>

        
        <tr>
            <td> Rules: </td>
            <td> 
                <tr v-for="rule in this.Boat.rules" v-bind:key="rule.id_rules" >
                    {{ rule.description }} 
                </tr>
            </td>
        </tr>
        <tr>
        
        <td  colspan ="2"> <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  v-on:click="$router.go(-1)"> Home page </button> </td>
        </tr>
    </table>
</div>
</template>

<script>
 import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



export default {
  data() {
    return {
        Boat: {},
        id: this.$route.params.id
    }
  },
  mounted() {
      this.getBoatByID();

    },
     methods:
     {     
         
         getBoatByID: function()
        { 
            
            this.axios.post('/boat/findById/'+this.id,
                {
                    headers: 
                    {
                        
                        
                    }}).then(response => 
                    {
                        this.Boat = response.data;
                        console.log(this.Boat);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        }
   
}
}

</script>

