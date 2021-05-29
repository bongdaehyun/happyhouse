<template>
<div>
    <Navbar />
    <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">My Page</h2>
                   
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item"><router-link :to="{name:'Home'}">Home</router-link></li>
                        <li class="breadcrumb-item active">mypage</li>
                    </ul>
                    
                </div>
            </template>
    </Breadcrumb>
    <!-- feature app section -->
        <div class="feature-app-showcase section-space--ptb_90 border-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <FeatureApp />
                    </div>
                </div>
            </div>
        </div>
</div>
</template>
<script>
//import http from '@/util/http-common'
import axios from "axios"
import Navbar from '@/components/MyFile/IncludeFile/Navbar'
import Breadcrumb from '@/components/Breadcrumb'
import FeatureApp from '@/components/MyFile/User/FeatureApp'

export default {
    data(){
        return{
            user:null,
        }
    },
    components:{
        Navbar,
        Breadcrumb,
        FeatureApp,
    },
    created(){
        axios.get("http://localhost:7070/happyhouse/user/info").then((response) => {
        this.user = response.data.user;
        }).catch(() => {
        this.$store.dispatch("logout").then(() => this.$router.replace("/"));
        });
    },
    methods:{
        modifyUser(){
            //alert("수정")
            axios.put(`http://localhost:7070/happyhouse/user/${this.user.userid}`,this.user)
            .then((data)=>{
                
                alert("수정 완료 다시 로그인 해주세요!~!")
                this.onClickLogout()
                
            })
            
        },
        DeleteUser(){
            axios.delete(`http://localhost:7070/happyhouse/user/${this.user.userid}`).then((data)=>{
                
                alert("탈퇴 완료")
                this.onClickLogout()
            })
        },
        onClickLogout() {
            this.$store.dispatch("logout")
                .then(() => this.$router.replace("/")
                .catch(() => {}));
        },
    }
};
</script>
<style>
</style>
