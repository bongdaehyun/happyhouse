<template>
    <section class="hero-branding bg-cover" :style="bgImg" id="home">
        <div class="container-fluid container-fluid--cp-150">
            <div class="hero-branding">
                <div class="hero-content">
                    <h2 class="h1 hero-content-title">Find Your Happy House</h2>
                    <h6 class="hero-content-subtitle mt-20">생생한 리뷰와 함께 진실된 정보만을 전달합니다.</h6>
                    <div class="slider-button mt-30" v-if="!getAccessToken">
                        <router-link :to="{ path: 'login' }" class="ht-btn ht-btn-md">Find My House</router-link>
                    </div>
                    <div class="slider-button mt-30" v-if="getAccessToken">
                        <router-link :to="{ path: 'list' }" class="ht-btn ht-btn-md">Find My House</router-link>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
import { mapGetters } from "vuex";
    export default {
        data (){
            return {
                bgImg: {
                    backgroundImage: `url(${require('../assets/img/hero/branding/branding.jpg')})`
                },
            }
        },
        computed: {
        ...mapGetters(["getAccessToken"])
        },
    }
</script>

<style lang="scss" scoped>
    @import '../assets/scss/variabls.scss';
    @import '../assets/scss/elements/hero-branding.scss'
    
</style>
