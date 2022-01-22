<template>
<div>
<div style="margin: 0 auto%; width: 80%;">
    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
    v-on:click="$router.go(-1)"> Home page </button><br>
    <h2> Write complain: </h2>
    <select v-model="type" id="reservationType" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="type"
                                          style="font-size:22px;"
                                          v-on:change="getNames()"
                                    aria-describedby="addon-wrapping">
                                    <option  value="" > Select type ... </option>
                                    <option  value="COTTAGE" > Cottage </option>
                                    <option  value="BOAT"> Boat </option>
                                    <option  value="ADVENTURE"> Adventure </option>
    </select>
    <select v-model="e" id="reservationType" class="form-control" 
                                          aria-label="Select reservation type.."
                                          :select="e"
                                          style="font-size:22px;"
                                    aria-describedby="addon-wrapping">
                                    <option v-for="a in this.entity" v-bind:key="a"  > {{a}}</option>
                                    
    </select>

    <v-container fluid>
    <v-textarea
      name="input-7-1"
      filled
      label="Insert yout complain....."
      auto-grow v-model="textComplain"     
      
    ></v-textarea>
  </v-container>
   <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
    v-on:click="sendComplain(textComplain, e, type)"> Submit </button>


</div>
</div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  data() {
    return {
        Cottage: {},
        id: this.$route.params.id,
        entity: [],
        type:"",
        e: "",
        
        textComplain: ""
    }
  },
  mounted() {
      //this.getCottageByID();

    },
     methods:
     {     
         
         getNames: function()
        { 
            this.entity = [];
            console.log("AAA");
            this.axios.post('/complains/cottageNames/'+this.id+'/'+this.type,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.entity = response.data;   
                                    console.log(this.entity);
                                    this.$router.go(-1);                                    

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });
            
        },
        sendComplain: function(txt, entity, type)
        {
            alert("Please wait a few minutes....");
            const complaint =
            {
                id_client: this.id,
                entityName: type,
                text: txt,
                name: entity


            }
            console.log(complaint);
           
            console.log("AAA");
            this.axios.post('/complains/saveComplain/',complaint,{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                        alert("Send successeffully!");
                                        console.log(response.data);  
                                                                       

                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });


        },
        
   
}
}

</script>
