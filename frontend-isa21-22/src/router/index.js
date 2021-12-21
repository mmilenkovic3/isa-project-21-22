import Vue from 'vue'
import VueRouter from 'vue-router'
import SignIn from '../components/SignIn.vue'
//import 'bootstrap'
//import HelloWorld from '../components/HelloWorld.vue'
import { BootstrapVue } from 'bootstrap-vue'
import Registration from '../components/Registration.vue'
Vue.use(VueRouter)
Vue.use(BootstrapVue)
//Vue.use(IconsPlugin)
/*Vue.filter('formatDate', function(value) {
  if (value) {
      return moment(String(value)).format('DD/MM/YYYY')
  }
});*/


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
const routes = [
    {
      path: '/SignIn',
      name: 'SignIn',
      component: SignIn
    },
    {
      path: '/Registration',
      name: 'Registration',
      component: Registration
    }
]
    
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
    
  })
  
  export default router