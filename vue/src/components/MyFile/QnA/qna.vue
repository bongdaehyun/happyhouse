<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">Q&A</h2>
                    <!-- breadcrumb-list start -->
                    <div class="breadcrumb-list">
                        Q&A 게시판입니다.
                    </div>
                    <!-- 설명에 링크를 추가하려면 아래처럼 하면 됩니다. -->
                     <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'qna'}">QnA</router-link>
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
                                <a class="portfolio-categories" href="#">ASK</a>
                                <h3 class="portfolio-details-title">QNA</h3>
                            </div>
                            <div class="text mt-20">
                                <p>누구나 자유롭게 작성할 수 있는 게시판입니다. 질문 사항을 올려주시면 빠른 시일 내로 관리자가 답변을 달아드립니다.</p>
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
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <div class="input-group mb-4">
                                            <input class="form-control" placeholder="제목으로 검색" type="text" v-model="searchText">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="button" class="btn btn-info" @click="Search">검색</button>
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
                                        <tr v-for="(qna,index) in qnas" :key="index">
                                            <td  class="text-center">{{qna.qnaid}}</td>
                                            <td class="text-center">
                                                <router-link :to="{name: 'qnaDetail', params: {qnaid:qna.qnaid}}"> {{qna.qnatitle}}</router-link>
                                            </td>
                                            <td class="text-center">{{qna.qnawriter}}</td>
                                            <td class="text-center">{{getFormatDate(qna.date)}}</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="mr-6" align="right"  v-if="getAccessToken">
                                    <button type="button" class="btn" @click="moveCreate">글작성</button>
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
    name: "qna",
    components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu
        },
        computed: {
    ...mapGetters(["getAccessToken", "getUserId"])
    },
    data(){
        return{
            searchText:'',
            qnaid:'',
            qnatitle:'',
            date:'',
            qnas:[],

        }
    },
    created(){
        
        http.get(`/qna/list`)
        .then(({data})=>{
        this.qnas=data;
        })
        
    },
    methods:{
        Search(){
            
            http.get(`/qna/title?word=${this.searchText}`)
            .then(({data})=>{
            this.qnas=data
            })
            
        },
        getFormatDate(regtime) {
            return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
        },
        moveCreate(){
            this.$router.push("/qnawrite")
        }
    },
};
</script>
<style scoped>
table thead th{
padding: 10px;
  font-weight: bold;
  border-top: 1px solid #ccc;
  border-right: 1px solid #ccc;
  border-bottom: 2px solid #c00;
  background: #dcdcd1;
}
</style>
