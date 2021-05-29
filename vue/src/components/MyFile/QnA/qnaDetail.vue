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
                <div > 
                    <div>
                        <div class="portfolio-details-content">
                            <div class="portfolio-details-title">
                                <a class="portfolio-categories" href="#">ASK</a>
                                <h3 class="portfolio-details-title">QNA 게시글</h3>
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
                                            <td><p style="width:100%;">{{qnaData.qnatitle}}</p></td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">내용</th>
                                            <td><p  style="width:100%; white-space:pre; " rows="15">{{qnaData.qnacontent}}</p>
                                        </td>
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

                            <div v-if="getUserId==qnaData.qnawriter">
                                <a href='#' @click="moveModify" class="btn btn-link text-success" >수정</a>
                                <a>&nbsp &nbsp</a>
                                <a href='#' @click="Delete" class="btn btn-link text-warning" >삭제</a>
                            </div>

                            <div class="btnWrap"  align="right">
                                <a href="javascript:;" @click="moveBack" class="btn">목록</a>
                                <!-- <a>&nbsp &nbsp</a>
                                <a href="javascript:;" @click="regist" class="btnAdd btn">등록</a> -->
                            </div>	


                            <div class="portfolio-details-table mt-30">
                                <comment-write :qnaid="qnaid" />
                                <comment-write v-if="isModifyShow && this.modifyComment != null"
                                :modifyComment="this.modifyComment" 
                                @modify-comment-cancel="onModifyCommentCancel" />
                                    <comment v-for="(comment, index) in comments" :key="index" 
                                :comment="comment" @modify-comment="onModifyComment" />
                                
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
    import Comment from "@/components/MyFile/comment/comment"
    import CommentWrite from "@/components/MyFile/comment/commentWrite"
    import {mapGetters} from 'vuex';

    export default {
    name: "detail",
    components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu,
            Comment,
            CommentWrite,
        },
    data(){
        return{
            qnaid:Number,
            qnaData:null,
            //comments:[],
            isModifyShow: false,
            modifyComment: Object
        }
    },
    computed:{
    ...mapGetters(["getUserId","comments","getUserCode"])
    },
    created(){
        this.qnaid=this.$route.params.qnaid;
        //console.log(this.$route.params)
        //console.log(this.$route.params.qnaid)
        http.get(`/qna/${this.$route.params.qnaid}`)
        .then(({data})=>{
            this.qnaData=data
            console.log(this.qnaData)
        }).catch(()=>(this.$router.push("/qna")))
        // http.get(`/comment/${this.$route.params.qnaid}`)
        // .then(({data})=>{
        //     this.comments=data;
        // })
        this.$store.dispatch("getComments", this.qnaid);
       
    },
    methods:{
        moveBack(){
            this.$router.go(-1)
        },
        Delete(){
            if(this.getUserId!=this.qnaData.qnawriter){
                alert("작성자 이외 사람은 삭제할수 없습니다.")
                return
            }
            http.delete(`/qna/${this.$route.params.qnaid}`).then((data)=>{
                // alert("삭제 완료")
                this.$router.push("/qna")
            })
        },
        moveModify(){
            if(this.getUserId!=this.qnaData.qnawriter){
                alert("작성자 이외 사람은 수정할수 없습니다.")
                return
            }
            this.$router.push({name: 'qnaModify', params: {qnaid:this.qnaData.qnaid}})
        },
        onModifyComment(comment) {
            this.modifyComment = comment;
            this.isModifyShow = true;
        },
        onModifyCommentCancel(isShow) {
            this.isModifyShow = isShow;
        }
    }
};
</script>

<style>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
