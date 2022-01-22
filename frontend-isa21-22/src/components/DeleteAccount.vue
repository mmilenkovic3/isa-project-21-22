<template>
<div>
<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
    v-on:click="$router.go(-1)"> Home page </button><br>
<h1> Requests: </h1>
    <table class="table" v-for="c in this.DeleteRequest" v-bind:key="c.id_req" 
    style="margin:0 auto; width: 60%; border: 1px black solid;" 
    >
        <tr v-if="!c.approved"> 
            <td style ="text-align: center;"> Email user: </td>
            <td style ="text-align: center;"> {{ c.email }}</td>
        </tr>
        <tr v-if="!c.approved"> 
            <td style ="text-align: center;"> Text: </td>
            <td style ="text-align: center;"> {{ c.text }}</td>
        </tr>

        <tr v-if="!c.approved"> 
            <td colspan= "2" style ="text-align: center;"> Your answer: </td>            
        </tr>
        <tr v-if="!c.approved"> 
            <td colspan= "2" style ="text-align: center;">  <v-container fluid>
                    <v-textarea
                    name="input-7-1"
                    filled
                    label="Insert yout complain....."
                    auto-grow v-model="textComplain"     
                    
                    ></v-textarea>
                </v-container></td>            
        </tr>
        <tr  v-if="!c.approved"> 
            <td style ="text-align: center;"> <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
                    v-on:click="approve(c.id_req, textComplain)">  Approve  </button> </td>
            <td style ="text-align: center;"> <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
                    v-on:click="disapprove(c.id_req, textComplain)"> Disapprove </button></td>
        </tr>
        
         <!--<tr > 
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
        </tr>-->


    
    </table>

</div>
</template>


<script>
export default{

    data()
    {
        return{           
        DeleteRequest: [],
        textComplain: "",
        
        }
    },
    mounted()
    {
        this.getAllDeleteRequest();
    },
   
    methods:
    {
        approve: function(id, text)
        {
            if(text == "")
                alert("Fill the ansert..");
            else
            {
                alert("Wait.. please..!");
                this.axios.post('/deleteAcc/approve/'+id+'/'+text, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')

                        
                    }}).then(response => 
                    {   
                        alert("SUCCESS!");
                         this.getAllDeleteRequest();
                         this.textComplain="";
                        console.log(response);                       
                                                
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
            }
        },
        disapprove: function(id, text)
        {
            if(text == "")
                alert("Fill the ansert..");
            else
            {
                alert("Wait.. please..!");
                this.axios.post('/deleteAcc/disapprove/'+id+'/'+text, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {   
                        alert("SUCCESS!");
                         this.getAllDeleteRequest();
                        console.log(response);                       
                                                
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });
            }
        },
         
        getAllDeleteRequest: function()
        {
            
            this.axios.get('/deleteAcc/getAll', {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {   
                        this.DeleteRequest = response.data;
                        console.log(this.DeleteRequest);                       
                                                
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });

        }
    }

}
</script>