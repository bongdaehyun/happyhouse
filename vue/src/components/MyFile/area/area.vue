<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">관심지역</h2>
                    <!-- breadcrumb-list start -->
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link to="{name:'Home'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'area'}">MyArea</router-link>
                        </li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </template>
        </Breadcrumb>
        <!-- breadcrumb end -->

       <div class="ht-tab-wrap">
        <b-tabs class="ht-tab-menu wow move-up">
            <b-tab title="나의 관심지역" active>
                <!-- tab content one component -->
                <div class="tab-history-wrap section-space--mt_80">
                    <div class="row">
                        <div class="col-lg-3">
                        </div>
                        <div class="col-lg-6">
                            <div class="tab-content-inner">
                                <card shadow class="card-profile mt--300" no-body v-if="this.check">
                                        <div class="px-4">
                                            <div class="text-center mt-5">
                                                <h3>{{this.info.city}}
                                                    <span class="font-weight-light">,{{this.info.gugun}} </span>
                                                    ,{{this.info.dong}}
                                                </h3>
                                                <div class="h6 font-weight-300"><i class="ni location_pin mr-2"></i></div>
                                                
                                            <button type="button" class="btn btn-info" @click="doDelete">삭제</button>
                                            </div>
                                        </div>
                                </card>
                                <card shadow class="card-profile" no-body v-else>
                                        <div class="px-4">
                                            <div class="text-center mt-5">
                                                <h2>나의 관심 지역이 </h2>
                                                <h2>설정되어 있지 않습니다.</h2>
                                            </div>
                                        </div>
                                </card>
                            </div>
                        </div>
                    </div>
                </div>
            </b-tab>
            <b-tab title="관심지역 설정">
                <!-- tab content two component -->
                <div class="tab-mission-wrap section-space--mt_60">
                    <div class="row align-items-center">
                        <div class="col-lg-3">
                            
                        </div>
                        <div class="col-lg-6">
                            <div class="tab-content-inner">
                                <div class="row">
                                    <div class="col-md-3">
                                            <b-form-select
                                            v-model="city"
                                            :options="Cityoptions"
                                            value-field="item"
                                            text-field="name"
                                            />
                                    </div>
                                    <div class="col-md-3">
                                            <b-form-select
                                            v-model="gugun"
                                            :options="Gugunoptions"
                                            value-field="item"
                                            text-field="name"
                                            
                                            @change="getDong"
                                            />
                                    </div>
                                <div class="col-md-3">
                                            <b-form-select
                                            v-model="dong"
                                            :options="Dongoptions"
                                            value-field="item"
                                            text-field="name"
                                            />
                                </div>
                                <div class="col-md-2">
                                        <button type="button" class="btn btn-info" @click="doRegister">등록</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </b-tab>
        </b-tabs>
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
    import PaymentFeature from '@/components/PaymentFeature'
    import Navbar from '@/components/MyFile/IncludeFile/Navbar'
    import http from "@/util/http-common"
    import {mapGetters} from 'vuex';
    
    
    export default {
        name: 'TabOne',
        components: {
            Navbar,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu,
            PaymentFeature,
            
        },
        data(){
            return{
                city:'서울특별시',
                gugun:'',
                dong:'',
                Cityoptions:[{item:"서울특별시",name:"서울특별시"}
                        ],
                Gugunoptions:[],
                Dongoptions:[],
                info:null,
                check:false,
            }
        },
        computed:{
            ...mapGetters(["getUserId","getUserCode"])
        },
        created(){
    
    let options=[]
    http.get("/search/gugun?city="+this.city).then(({data})=>{
        data.forEach(element => {
            let option={}
            option['item']=element
            option['name']=element
            options.push(option)
        });
    });
    this.getMyarea()
    this.Gugunoptions=options 
  },
  methods:{
      doRegister(){
          http.get(`/myapi/code?city=${this.city}&dong=${this.dong}&gugun=${this.gugun}`).then(({data})=>{
                this.updateCode(data)
          })
         
      },
      getDong(){
        let options=[]
        http.get("/search/donglist?gugun="+this.gugun).then(({data})=>{
            data.forEach(element => {
            let option={}
            option['item']=element
            option['name']=element
            options.push(option)
            });
        })
        this.Dongoptions=options
      },
      updateCode(code){
          http.put(`/myapi/${this.getUserId}?code=${code}`).then((data)=>{
             
              if(data.data=="success"){
                  alert("등록 완료")
                  this.$store.dispatch("getCode", code).then(
                      console.log(this.getUserCode)
                  );
                  this.$router.push("/")
                  return
              }
              alert("등록 실패")
          })
      },
      isCode(){
          //console.log("코드있나?"+this.getUserCode)
          if(this.getUserCode=='""' || this.getUserCode.length==0){
              //console.log("실행")
              this.check=false
              return false;
          }else{
              //console.log("실행2")
              this.check=true
              return true;
          }
      },
      getMyarea(){
          if(this.isCode()){
              //console.log("실행66666")
              http.get(`/myapi?code=${this.getUserCode}`).then(({data})=>{
                  this.info=data;
                  //console.log(data);
              })
          }
      },
      doDelete(){
          http.put(`/myapi/${this.getUserId}?code=""`).then((data)=>{
             
              if(data.data=="success"){
                  alert("삭제 완료")
                  this.$store.dispatch("getCode", "");
                  this.$router.push("/")
                  return
              }
              alert("삭제 실패")
          })
      }
  }
    };
</script>