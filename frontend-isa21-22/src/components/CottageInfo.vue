<template>
<div style="margin: 0 auto; width: 60%;">
    <h1> {{ this.Cottage.name}} </h1>
    <table class="table">        
        <tr>
            <td> Address: </td>
            <td> {{this.Cottage.address}}</td>
        </tr>
        <tr>
            <td> Grade: </td>
            <td> {{this.Cottage.grade}}</td>
        </tr>
         <tr>
            <td> Bed number: </td>
            <td> {{this.Cottage.numBed}}</td>
        </tr>
         <tr>
            <td> Room number: </td>
            <td> {{this.Cottage.numRoom}}</td>
        </tr>
         <tr>
            <td> Price: </td>
            <td> {{this.Cottage.price}} e</td>
        </tr>
         <tr>
            <td> Promo description: </td>
            <td> {{this.Cottage.promoDescription}}</td>
        </tr>

        <tr>
            <td> Information: </td>
            <td> {{this.Cottage.info}}</td>
        </tr>
        <tr>
            <td> Rules: </td>
            <td> 
                <tr v-for="rule in this.Cottage.rules" v-bind:key="rule.id_rules" >
                    <td> {{ rule.description }}  </td>                    
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
        Cottage: {},
        id: this.$route.params.id
    }
  },
  mounted() {
      this.getCottageByID();

    },
     methods:
     {     
         
         getCottageByID: function()
        { 
            
            this.axios.post('/cottage/findById/'+this.id,
                {
                    headers: 
                    {
                        
                        
                    }}).then(response => 
                    {
                        this.Cottage = response.data;
                        console.log(this.Cottage);
                        //this.$router.push('/SignIn');  

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    }); 
        }
   
}
}

</script>

