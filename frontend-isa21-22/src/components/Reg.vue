<template>
<div>
<div style="margin: 0 auto%; width: 80%;">
    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
    v-on:click="$router.go(-1)"> Home page </button><br>
    <h2> Zahtevi: </h2>
    <!--<table class="table" v-for="c in this.Complains" v-bind:key="c.id_complain"
    style="margin:0 auto; width: 60%; border: 1px black solid;"
    >
        <tr > 
            <td style ="text-align: center;"> Complain id: </td>
            <td style ="text-align: center;"> {{ c.id_complain }}</td>
        </tr>
        <tr > 
            <td style ="text-align: center;"> Cottage/Boat/Adventure: </td>
            <td style ="text-align: center;"> {{ c.reservationType }}</td>
        </tr>
        <tr > 
            <td style ="text-align: center;"> Client: </td>
            <td style ="text-align: center;"> {{ c.client_name }}</td>
        </tr>
         <tr > 
            <td style ="text-align: center;"> Text: </td>
            <td style ="text-align: center;"> {{ c.textComplain }}</td>
        </tr>
         <tr > 
            <td style ="text-align: center;"> Answer: </td>
            <td style ="text-align: center;" v-show="c.answered == true"> {{ c.answer }}</td>
            <td style ="text-align: center;" v-if="c.answered == false"> 
            <v-container fluid>
                    <v-textarea
                    name="input-7-1"
                    filled
                    label="Insert yout complain....."
                    auto-grow v-model="textComplain"     
                    
                    ></v-textarea>
                </v-container>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
                    v-on:click="answer(c.id_complain, textComplain)"> Submit </button>
                    </td>
        </tr>


    
    </table>-->
    


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
       
        type:"",
       
        requests: [],
        
        textComplain: ""
    }
  },
  mounted() {
      this.getRequestReg();

    },
     methods:
     {   
         
         getRequestReg: function()
        { 
            this.entity = [];
            console.log("AAA");
            this.axios.get('admin/getRequestReg',{
                                    headers: 
                                    {
                                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                        
                                    }}).then(response => 
                                    {
                                    this.requests = response.data;   
                                    console.log(this.requests);                                  


                                    }).catch(res => {
                                        console.log(res);                       
                                        event.preventDefault();

                                    });
            
        }
     }
        
}

</script>
