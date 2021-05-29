<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">Notice</h2>
                    <!-- breadcrumb-list start -->
                    <div class="breadcrumb-list">
                        공지사항 게시판입니다.
                    </div>
                    <!-- 설명에 링크를 추가하려면 아래처럼 하면 됩니다. -->
                     <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'notice'}">Notice</router-link>
                        </li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </template>
        </Breadcrumb>
        <!-- breadcrumb end -->

        <!-- portfolio details wrapper start -->
        <div class="portfolio-details-wrapper section-space--ptb_100">
            <div class="container">
                <div> 
                    <div>
                        <div class="portfolio-details-content">
                            <div class="portfolio-details-title">
                                <a class="portfolio-categories" href="#">Look!</a>
                                <h3 class="portfolio-details-title">NOTICE</h3>
                            </div>
                            <div class="text mt-20">
                                <p>공지사항 게시판입니다. 반드시 읽어주시고 서비스를 이용해주세요.</p>
                            </div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <div class="input-group mb-4">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <div class="input-group mb-4">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="portfolio-details-table mt-30">
                                <table class="mb-0 table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th class="text-center">글번호</th>
                                            <th class="text-center">제목</th>
                                            <th class="text-center">작성자</th>
                                            <th class="text-center">작성일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(notice,index) in notices" :key="index">
                                            <td  class="text-center">{{notice.noticeid}}</td>
                                            <td class="text-center">
                                                <router-link :to="{name: 'noticeDetail', params: {noticeid:notice.noticeid}}"> {{notice.noticetitle}}</router-link>
                                            </td>
                                            <td class="text-center">{{notice.noticewriter}}</td>
                                            <td class="text-center"> {{getFormatDate(notice.date)}}</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="mr-6" align="right"  v-if="getAccessToken">
                                    <div v-if="getUserId=='ssafy'">
                                        <button type="button" class="btn" @click="moveCreate">글작성</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

      
        <!-- portfolio details wrapper end -->

        <!-- footer section -->
        <Footer />

        <!-- offcanvas search component -->
        <OffcanvasSearchBox />

        <!-- off-canvas mobile menu -->
        <OffCanvasMobileMenu />

    </div>
</template>

<script>
    import Navbar from '@/components/MyFile/IncludeFile/Navbar'
    import HeaderElement from '@/components/HeaderElement'
    import Breadcrumb from '@/components/Breadcrumb'
    import Footer from '@/components/MyFile/IncludeFile/Footer'
    import OffcanvasSearchBox from '@/components/OffcanvasSearchBox'
    import OffCanvasMobileMenu from '@/components/OffCanvasMobileMenu'
    import http from '@/util/http-common'
    import moment from 'moment';
    import { mapGetters } from "vuex";

    export default {
    name: "notice",
    components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu
        },
    data(){
        return{
            searchText:'',
            noticeid:'',
            noticetitle:'',
            date:'',
            notices:[],

        }
    },
    computed: {
    ...mapGetters(["getAccessToken", "getUserId"])
    },
    created(){
        
        http.get(`/notice`)
        .then(({data})=>{
        this.notices=data;
        })
        
    },
    methods:{
        getFormatDate(regtime) {
            return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
        },
        moveCreate(){
            this.$router.push("/noticewrite")
        }
    },
};
</script>

