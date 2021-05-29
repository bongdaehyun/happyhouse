<template>
    <div class="feature-list__one">
        <div class="row">
            <div class="col-lg-6 wow move-up">
                <div class="grid-item animate">
                    <div class="ht-box-icon style-01">
                        <div class="icon-box-wrap">
                            <div class="image">
                                <img src="@/assets/img/icons/aeroland-app-showcase-box-icon-image-01.png" class="img-fluid" alt="aeroland-app-showcase-box-icon-image-01">
                            </div>
                            <div class="content">
                                <h6 class="heading">UserId</h6>
                                <div class="text"></div>
                                <base-input alternative
                                            class="mb-3"
                                            placeholder="id"
                                            type="text"
                                            disabled
                                            v-model="user.userid"
                                            >
                                </base-input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 wow move-up">
                <div class="grid-item animate">
                    <div class="ht-box-icon style-01">
                        <div class="icon-box-wrap">
                            <div class="image">
                                <img src="@/assets/img/icons/aeroland-app-showcase-box-icon-image-02.png" class="img-fluid" alt="aeroland-app-showcase-box-icon-image-01">
                            </div>
                            <div class="content">
                                <h6 class="heading">UserPwd</h6>
                                <div class="text"></div>
                                <base-input alternative
                                            class="mb-3"
                                            placeholder="******"
                                            type="password"
                                            v-model="user.userpw"
                                            >
                                </base-input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 wow move-up">
                <div class="grid-item animate">
                    <div class="ht-box-icon style-01">
                        <div class="icon-box-wrap">
                            <div class="image">
                                <img src="@/assets/img/icons/aeroland-app-showcase-box-icon-image-03.png" class="img-fluid" alt="aeroland-app-showcase-box-icon-image-01">
                            </div>
                            <div class="content">
                                <h6 class="heading">UserName</h6>
                                <div class="text"></div>
                                <base-input alternative
                                            class="mb-3"
                                            placeholder="홍싸피"
                                            type="text"
                                            v-model="user.username"
                                            >
                                </base-input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 wow move-up">
                <div class="grid-item animate">
                    <div class="ht-box-icon style-01">
                        <div class="icon-box-wrap">
                            <div class="image">
                                <img src="@/assets/img/icons/aeroland-app-showcase-box-icon-image-04.png" class="img-fluid" alt="aeroland-app-showcase-box-icon-image-01">
                            </div>
                            <div class="content">
                                <h6 class="heading">UserEmail</h6>
                                <div class="text"></div>
                                <base-input alternative
                                            class="mb-3"
                                            placeholder="email"
                                            type="text"
                                            v-model="user.useremail"
                                            >
                                </base-input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center">
            <button type="primary" class="btn btn--green" @click="modifyUser">수정</button>
            <button type="danger" class="btn btn--red" @click="DeleteUser">탈퇴</button>
        </div>
    </div>
</template>

<script>
import axios from "axios"
import BaseInput from "@/components/MyFile/UseBase/BaseInput"
    export default {
        name: 'FeatureApp',
        data (){
            return {
                user:null,
            }
        },
        components:{
            BaseInput,
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
    }
</script>
