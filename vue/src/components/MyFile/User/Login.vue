<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">LogIn</h2>
                    <!-- breadcrumb-list start -->
                    <div class="breadcrumb-list">
                        로그인 페이지 입니다
                    </div>
                    <!-- 설명에 링크를 추가하려면 아래처럼 하면 됩니다. -->
                     <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Login'}">LogIn</router-link>
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
                                <a class="portfolio-categories" href="#">User</a>
                                <h3 class="portfolio-details-title">LogIn</h3>
                            </div>
                            <div class="text mt-20">
                                <p>로그인을 하여 더 많은 서비스를 이용해보세요.</p>
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
                                            <input class="form-control" placeholder="ID" type="text" v-model="user.userid">
                                            </div>
                                            <div class="input-group mb-4">
                                            <input class="form-control" placeholder="PASSWORD" type="password" v-model="user.userpw">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="button" class="btn btn-info" @click="login">로그인</button>
                                    </div>
                                </div>
                                <div>
                                    <router-link to="/findpass"><a>비밀번호 찾기</a></router-link>
                                    <a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</a>
                                    <router-link to="/join"><a>회원가입</a></router-link>
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
    

    export default {
    name:"Login",
    data: function() {
    return {
        user: {
            userid: "",
            userpw: ""
        },
        message: ""
        };
    },
    components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu
        },
    computed:{
        nextRoute(){
            return this.$route.params.nextRoute? this.$route.params.nextRoute : "";
        }
    },
    methods: {
    login: function() {
      // LOGIN 액션 실행
      // 서버와 통신(axios)을 해 토큰값을 얻어야 하므로 Actions를 호출.
        //alert("로그인 버튼누름")
        this.$store.dispatch("login", this.user)
        .then(() => {
            
            this.$router.replace(`/${this.nextRoute}`)
            })
        .catch(({ message }) => (alert("로그인 정보를 다시 확인해주세요")));
        }
    },
};
</script>

