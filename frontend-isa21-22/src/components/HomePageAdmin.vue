<template>
<div>
    <h1> AA </h1>
</div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  data() {
    return {
      info: true,
      Cottages: false,
      pass: false,
      disabledButtons: true,
      user: {},

      inputName: "",
      inputSurName: "",
      inputAddress: "",
      inputPhoneNum: "",
      inputCity: "",
      inputCountry: "",
      inputEmail: "",
      inputPassword: "",
      inputRepeatPassword: "",


      password: "",
      newPassword: "",
      newPasswordRepeat: "",

      allCotages: [],
      
    }
  },
  
     methods:{              
    

      
   
},
mounted() {
    
    this.axios.get('/cottage/try/',
                {
                    headers: 
                    {
                       'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {                     
                        

                      console.log(response.data);

                    }).catch(res => {
                        console.log(res);
                        event.preventDefault();
                    });  
    },
}

</script>