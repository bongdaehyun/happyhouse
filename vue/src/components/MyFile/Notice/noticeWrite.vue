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
                <div > 
                    <div>
                        <div class="portfolio-details-content">
                            <div class="portfolio-details-title">
                                <a class="portfolio-categories" href="#">Look!</a>
                                <h3 class="portfolio-details-title">NOTICE 게시글 작성</h3>
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


                            <div>
                                <form>
                                    <table width="100%">
                                        <colgroup>
                                            <col width="10%" />
                                            <col width="90%" />
                                        </colgroup>
                                        <tr>
                                            <th class="text-center">제목</th>
                                            <td><input type="text" v-model="noticetitle" ref="noticetitle" style="width:100%;" /></td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">내용</th>
                                            <td><textarea v-model="noticecontent" ref="noticecontent" style="width:100%; " rows="15" placeholder="Write a large text here ..."></textarea></td>
                                        </tr>
                                    </table>
                                </form>
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

                            <div class="btnWrap"  align="right">
                                <a href="javascript:;" @click="moveBack" class="btn">목록</a>
                                <a>&nbsp &nbsp</a>
                                <a href="javascript:;" @click="regist" class="btnAdd btn">등록</a>
                            </div>	


                            <div class="portfolio-details-table mt-30">
                                
                                
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
    import http from "@/util/http-common"
    import {mapGetters} from 'vuex'

    export default {
    name: "detail",
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
            user:null,
            noticetitle:"",
            noticecontent:"",
        }
    },
    computed:{
        ...mapGetters(["getUserId"])
    },
    methods:{
    moveBack(){
        this.$router.go(-1)
    },
    regist(){
        http.post("/notice",{
            noticetitle:this.noticetitle,
            noticewriter: this.getUserId,
            noticecontent:this.noticecontent,
            date: new Date()
                }).then(({data})=>{
                    // alert("등록완료")
                    this.$router.push("/notice")
                    })
        }
    }
};
</script>

