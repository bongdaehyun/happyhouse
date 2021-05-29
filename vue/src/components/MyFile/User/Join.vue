<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">Join</h2>
                    <!-- breadcrumb-list start -->
                    <div class="breadcrumb-list">
                        회원가입 페이지 입니다
                    </div>
                    <!-- 설명에 링크를 추가하려면 아래처럼 하면 됩니다. -->
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'Login'}">Join</router-link>
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
                                <h3 class="portfolio-details-title">Join</h3>
                            </div>
                            <div class="text mt-20">
                                <p>회원가입을 하여 보다 많은 정보와 혜택을 받을 수 있습니다.</p>
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
                            <div id="wrapper">
                                <template>
                                    <div class="text-center text-muted mb-4">
                                        
                                    
                                    <form>
                                        <table style="width:40%; height: 100px; margin: auto; text-align: center;">
                                            <colgroup>
                                                <col width="30%" />
                                                <col width="70%" />
                                            </colgroup>
                                            <tr>
                                                <th class="text-center mb-3">성명</th>
                                                <td><input type="text" v-model="user.username" style="width:100%;" /></td>
                                            </tr>
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
                                            <tr>
                                                <th class="text-center mb-3">아이디</th>
                                                <td><input type="text" v-model="user.userid"  style="width:100%;" /></td>
                                            </tr>
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
                                            <tr>
                                                <th class="text-center mb-3">이메일</th>
                                                <td><input type="text" v-model="user.useremail"  style="width:100%;" /></td>
                                            </tr>
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
                                            <tr>
                                                <th class="text-center mb-3">비밀번호</th>
                                                <td><input type="password" v-model="user.userpw"  style="width:100%;" /></td>
                                            </tr>
                                        </table>
                                    </form>
                                    </div>
                                </template>
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
                            </div> 
                            <div class="container">
                                <div class="row">

                                </div>
                                <div class="mr-6" align="center">
                                    <button type="button" class="btn" @click="regist">회원가입</button>
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

    export default {
    name:"Join",
    data(){
        return{
            user:{
                username:"",
                useremail:"",
                userid:"",
                userpw:"",
                code:""
            }
        }
    },
    methods:{
        regist(){
            //alert("등록")
            http.post("/user",this.user).then(({data})=>{
                let msg = "등록 처리시 문제가 발생했습니다.";
                if (data === "success") {
                    msg = "등록이 완료되었습니다.";
                }
                alert(msg);
                this.$router.push("/");
            })
            
        }
    },
    components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu
    },
};
</script>

<style>
#logo {
    width: 240px;
    height: 44px;
    cursor: pointer;
}

#header {
    padding-top: 62px;
    padding-bottom: 20px;
    text-align: center;
}
#wrapper {
    position: relative;
    height: 100%;
}

#content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 460px;
}




/* 입력폼 */





.box {
    display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}

.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
}

input {
    font-family: Dotum,'돋움',Helvetica,sans-serif;    
}

.box.int_id {
    padding-right: 110px;
}

.box.int_pass {
    padding-right: 40px;
}

.box.int_pass_check {
    padding-right: 40px;
}

.step_url {
    /*@naver.com*/
    position: absolute;
    top: 16px;
    right: 13px;
    font-size: 15px;
    color: #8e8e8e;
}

.pswdImg {
    width: 18px;
    height: 20px;
    display: inline-block;
    position: absolute;
    top: 50%;
    right: 16px;
    margin-top: -10px;
    cursor: pointer;
}

#bir_wrap {
    display: table;
    width: 100%;
}

#bir_yy {
    display: table-cell;
    width: 147px;
    
}

#bir_mm {
    display: table-cell;
    width: 147px;
    vertical-align: middle;
}

#bir_dd {
    display: table-cell;
    width: 147px;
}

#bir_mm, #bir_dd {
    padding-left: 10px;
}

select {
    width: 100%;
    height: 29px;
    font-size: 15px;
    background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
    background-size: 20px 8px;
    -webkit-appearance: none;
    display: inline-block;
    text-align: start;
    border: none;
    cursor: default;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}

/* 에러메세지 */

.error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;    
    display: none;
}

#alertTxt {
    position: absolute;
    top: 19px;
    right: 38px;
    font-size: 12px;
    color: red;
    display: none;
}

/* 버튼 */

.btn_area {
    margin: 30px 0 91px;
}

#btnJoin {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: #08a600;
    font-size: 20px;
    font-weight: 400;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}
</style>