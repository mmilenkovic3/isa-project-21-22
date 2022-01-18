<template>
<div style="margin: 0 auto; width: 60%;">
    <h1> {{ this.Adventure.name}} </h1>
    <table class="table">        
        <tr>
            <td> Address: </td>
            <td> {{this.Adventure.address}}</td>
        </tr>
        <tr>
            <td> Grade: </td>
            <td> {{this.Adventure.grade}}</td>
        </tr>
         <tr>
            <td> Capacity: </td>
            <td> {{this.Adventure.capacity}}</td>
        </tr>
         <tr>
            <td> Instructor bio: </td>
            <td> {{this.Adventure.bio}}</td>
        </tr>
        
        <tr>
            <td> Fishing kig: </td>
            <td> 
                <tr v-for="f in this.Adventure.fishingKits" v-bind:key="f.id_fishing_kit" >
                     {{ f.name }}                    
                </tr>
            </td>
        </tr>
         <tr>
            <td> Price: </td>
            <td> {{this.Adventure.price}} e</td>
        </tr>
         <tr>
            <td> Promo description: </td>
            <td> {{this.Adventure.promoDescriptionAdventure}}</td>
        </tr>

        
        <tr>
            <td> Rules: </td>
            <td> 
                <tr v-for="rule in this.Adventure.rules" v-bind:key="rule.id_rules" >
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
        Adventure: {},
        id: this.$route.params.id
    }
  },
  mounted() {
      this.getAdventureByID();

    },
     methods:
     {     
         
         getAdventureByID: function()
        { 
            
            this.axios.post('/adventure/findById/'+this.id,
                {
                    headers: 
                    {
                        
                        
                    }}).then(response => 
                    {
                        this.Adventure = response.data;
                        console.log(this.Adventure);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        }
   
}
}

</script>

