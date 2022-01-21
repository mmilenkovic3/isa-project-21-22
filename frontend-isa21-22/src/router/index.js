import Vue from 'vue'
import VueRouter from 'vue-router'
//import SignIn from '../components/SignIn.vue'
//import 'bootstrap'
//import HelloWorld from '../components/HelloWorld.vue'
import { BootstrapVue } from 'bootstrap-vue'
import Registration from '../components/Registration.vue'
import Verify from '../components/Verify.vue'
import LoginPage from '../components/LoginPage.vue'
import HomePageUser from '../components/HomePageUser.vue'
import HomePageAdmin from '../components/HomePageAdmin.vue'
import Reservations from '../components/Reservations.vue'
import FastReservation from '../components/FastReservation.vue'
import System from '../components/System.vue'
import CottageInfo from '../components/CottageInfo.vue'
import BoatInfo from '../components/BoatInfo.vue'
import AdventureInfo from '../components/AdventureInfo.vue'
import AddNewAdmins from '../components/AddNewAdmins.vue'
import ChangeAdminPass from '../components/ChangeAdminPass.vue'
import ClientReservation from '../components/ClientReservation.vue'

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
      path: '/',
      name: '',
      component: System
    },
    {
      path: '/LoginPage',
      name: 'LoginPage',
      component: LoginPage
    },
    {
      path: '/Registration',
      name: 'Registration',
      component: Registration
    }
    ,
    {
      path: '/Verify/:id',
      name: 'Verify',
      component: Verify
    },
    {
      path: '/AddNewAdmins',
      name: 'AddNewAdmins',
      component: AddNewAdmins
    }
    ,
    {
      path: '/HomePageUser/:id',
      name: 'HomePageUser',
      component: HomePageUser
    },

    {
      path: '/HomePageAdmin/:id',
      name: 'HomePageAdmin',
      component: HomePageAdmin
    }

    ,

    {
      path: '/Reservations/:id',
      name: 'Reservations',
      component: Reservations
    },

    {
      path: '/FastReservation/:id',
      name: 'FastReservation',
      component: FastReservation
    }
    ,

    {
      path: '/CottageInfo/:id',
      name: 'CottageInfo',
      component: CottageInfo
    },

    {
      path: '/BoatInfo/:id',
      name: 'BoatInfo',
      component: BoatInfo
    }
    ,

    {
      path: '/ChangeAdminPass/:id',
      name: 'ChangeAdminPass',
      component: ChangeAdminPass
    }
    ,

    {
      path: '/AdventureInfo/:id',
      name: 'AdventureInfo',
      component: AdventureInfo
    } ,

    {
      path: '/ClientReservation/:id',
      name: 'ClientReservation',
      component: ClientReservation
    }
]
    
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
    
  })
  
  export default router