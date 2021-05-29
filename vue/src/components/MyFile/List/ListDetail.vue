<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">{{ $route.params.aptName }}</h2>
                    <!-- breadcrumb-list start -->
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'list'}">List</router-link>
                        </li>
                        <li class="breadcrumb-item active">ListDetail</li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </template>
        </Breadcrumb>
        <!-- breadcrumb end -->

        <!-- portfolio details wrapper start -->
        <div class="portfolio-details-wrapper section-space--ptb_100">
            <div class="container">
                <div class="row portfolio-details-feature-wrap">
                    <div class="col-lg-8">
                       <kakaomap :addr="addr"></kakaomap>
                    </div>
                    <div class="col-lg-4">
                        <div class="portfolio-details-content">
                            <div class="portfolio-details-title">
                                <a class="portfolio-categories" href="#">Apt</a>
                                <h3 class="portfolio-details-title">{{ $route.params.aptName }}</h3>
                            </div>
                            <div class="portfolio-details-table mt-30">
                                <table class="mb-0">
                                    <tbody>
                                        <tr class="portfolio-details-date">
                                            <td class="label">지번</td>
                                            <td>{{ $route.params.jibun}}</td>
                                        </tr>

                                        <tr class="portfolio-details-client">
                                            <td class="label">동</td>
                                            <td> {{ $route.params.dong }}</td>
                                        </tr>

                                        <tr class="portfolio-details-tags">
                                            <td class="label">층수</td>
                                            <td>
                                                {{ $route.params.floor }}
                                            </td>
                                        </tr>

                                        <tr class="portfolio-details-share">
                                            <td class="label">거래금액 </td>
                                            <td class="portfolio-sharing-list">
                                                <div class="inner">
                                                    {{ numberWithCommas($route.params.dealAmount) }}원
                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="portfolio-details-share">
                                            <td class="label">평 수 </td>
                                            <td class="portfolio-sharing-list">
                                                <div class="inner">
                                                    {{ $route.params.area }}
                                                </div>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" v-if="reviews.length>=1">
                <h2 align="center">실거주자 리뷰 분석</h2>
            <div class="row">
                <div class="col-lg-4">
                    <bar-chart :chartdata="chartdata"></bar-chart>
                </div>
                <div class="col-lg-6">
                    <word-cloud></word-cloud>
                </div>
            </div>
        </div>

        <div class="payment-feature section-space--pt_120 section-space--pb_90 bg-gray" v-if="reviews.length>=1">
            <div class="container">
                <!-- payment feature component -->
                <PaymentFeature />
            </div>
        </div>


        <div class="container" v-if="reviews.length>=1">
            <h2 align="center">실거주자 리뷰</h2>
            <div class="portfolio-details-content">
                            
                <div class="portfolio-details-table mt-30">
                    <table class="table mt-3 mr-3">
                        <colgroup>
                            <col width="10%">
                            <col width="10%">
                            <col width="10%">
                            <col width="10%">
                            <col width="60%">
                        </colgroup>
                        <thead>
                            <tr>
                                <th class="text-center">age</th>
                                <th>성별</th>
                                <th class="text-center">거주 기간</th>
                                <th>거주 타입</th>
                                <th class="text-center">리뷰</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(review, index) in reviews.slice(0,5)" :key="index">
                                
                                <td class="text-center">{{review.age}}</td>
                                <td>{{review.sex}}</td>
                                
                                <td class="text-center">{{review.residenceType}}</td>
                                <td class="text-center">{{review.residenceTime}}</td>
                                <td>{{review.desc}}</td>
                                
                            </tr>
                        </tbody>
                    </table>
            <div class="btn-cover" align="center" >
                <button :disabled="pageNum === 0" @click="prevPage" class="page-btn btn-info">
                    이전
                </button>
                <span class="page-count">  {{ pageNum + 1 }} / {{ pageCount }}  페이지  </span>
                <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn btn-info">
                    다음
                </button>
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
    //import HeaderElement from '@/components/HeaderElement'
    import Breadcrumb from '@/components/Breadcrumb'
    import Footer from '@/components/MyFile/IncludeFile/Footer'
    import OffcanvasSearchBox from '@/components/OffcanvasSearchBox'
    import OffCanvasMobileMenu from '@/components/OffCanvasMobileMenu'
    import PaymentFeature from '@/components/MyFile/List/PaymentFeature'
    import Navbar from '@/components/MyFile/IncludeFile/Navbar'
    import http from "@/util/http-common"

    import kakaomap from '@/components/MyFile/List/map'
    import BarChart from "@/components/MyFile/Review/chart"
    import WordCloud from "@/components/MyFile/Review/wordcloud"
    
    import {mapGetters} from 'vuex';

    export default {
        name: 'PortfolioGrid',
        components: {
            Navbar,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu,
            PaymentFeature,
            kakaomap,
            BarChart,
            WordCloud,
           
        },
        data(){
            return{
                addr:{
                    lat:'',
                    lng:'',
                    },
                chartdata:[],
                //reviews:[],
                pagination: {
                default: 1
                },
                pageNum:0,
            }
        },
        props:{
            pageSize: {
                type: Number,
                required: false,
                default: 10
            }
        },
        computed:{
            ...mapGetters(["getUserCode","reviews"]),
            pageCount () {
                let listLeng = this.reviews.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1;
                
                /*
                아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
                이런식으로 if 문 없이 고칠 수도 있다!
                */
                return page;
            },
            paginatedData () {
                //console.log(this.pageNum , this.pageSize)
                const start = this.pageNum * this.pageSize;
                const end = start + this.pageSize;
                //console.log(this.reviews)
                return this.reivews.slice(start, end);
            }
        },
        created(){
            //console.log(this.$route.params)
            this.addr.lat=this.$route.params.lat
            this.addr.lng=this.$route.params.lng
            http.get("/review/list?aptName="+this.$route.params.aptName)
            .then(({data})=>{
                //console.log(data)
                //this.reviews=data
                let minv=0
                let maxv=0
                data.forEach(item => {
                    if(item.score>3){
                        maxv++
                    }else{
                        minv++
                    }
                });
                
                this.chartdata.push(maxv)
                this.chartdata.push(minv)
                
                //console.log(this.chartdata)
            })
            this.$store.dispatch('getReviews',this.$route.params.aptName)
        },
        methods:{
            numberWithCommas(x) {
                // 숫자의 3자리마다 ',' 찍기
                return String(x).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            },
            moveBack(){
                this.$router.go(-1)
            },
            nextPage () {
            this.pageNum += 1;
            },
            prevPage () {
            this.pageNum -= 1;
            },
        }
    }
</script>
<style>
.wordCloud{
    width: 50%;
}
</style>
