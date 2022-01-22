<template>
<div>
<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"    
    v-on:click="$router.go(-1)"> Home page </button><br>
<h1> All complains: </h1>
    <table class="table" v-for="c in this.Complains" v-bind:key="c.id_complain"
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


    
    </table>

</div>
</template>


<script>
export default{

    data()
    {
        return{
        inputEmail: "",
       inputPassword: "",      
        Complains: [],
        
        }
    },
    mounted()
    {
        this.getAllComplains();
    },
   
    methods:
    {
         
        answer: function(id_complain, text)
        {
            alert("Wait a few moments please...");
            this.axios.post('/complains/answerComplain/'+id_complain+'/'+text, {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {                         
                        console.log(response);                         
                        alert("Success!");       
                        this.textComplain = "";                 
                        this.getAllComplains();  
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });

        },

        getAllComplains: function()
        {
            
            this.axios.get('/complains/getAllComplains', {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                        
                    }}).then(response => 
                    {   
                        this.Complains = response.data;
                        console.log(this.Complains);                       
                                                
                        event.preventDefault(); 

                    }).catch(res => {
                        console.log(res);                       
                        event.preventDefault();

                    });

        }
    }

}
</script>