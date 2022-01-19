<template>
    <div>    
    <div class="text">
        <input type="password" v-model="odlPass" class="form-control" placeholder="Password" required>
        <input type="password" v-model="pass" class="form-control" placeholder="Password" required>
        <input type="password" v-model="newPass" class="form-control" placeholder="Repeat Password" required>
              
    </div>
        <button v-if="!this.active" style="margin-top:20px; height: 50px;" v-on:click="accountEnabled()" class="btn btn-lg btn-primary btn-block btn-signin"> Continue </button>
        <button v-if="this.active"  style="margin-top:20px; height: 50px;" v-on:click="signIn()"  class="btn btn-lg btn-primary btn-block btn-signin2"> Sign in </button>
    </div>  
</template>