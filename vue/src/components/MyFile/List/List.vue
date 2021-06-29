<template>
    <div class="main-container">

        <router-view></router-view>

        <!-- Navbar section -->
        <Navbar />

        <!-- breadcrumb strat -->
        <Breadcrumb>
            <template slot="breadcrumb">
                <div class="breadcrumb_box text-center">
                    <h2 class="breadcrumb-title">Search</h2>
                    <!-- breadcrumb-list start -->
                    <div class="breadcrumb-list">
                        아파트명, 거래가로 검색하여 아파트별 실거래가  
                    </div>
                    <!-- 설명에 링크를 추가하려면 아래처럼 하면 됩니다. -->
                    <!-- <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'HomeBranding'}">Home</router-link>
                        </li>
                        <li class="breadcrumb-item">
                            <router-link :to="{name:'HomeBranding'}">Portfolio</router-link>
                        </li>
                        <li class="breadcrumb-item active">Portfolio Details</li>
                    </ul> -->
                    <!-- breadcrumb-list end -->
                </div>
            </template>
        </Breadcrumb>
        <!-- breadcrumb end -->
        
        <!-- portfolio details wrapper start -->
        <div class="portfolio-details-wrapper section-space--ptb_100">
            <div class="container">
                <div class="row ">
                    
                    <div class="col-md-2">
                            <b-form-select
                            
                            v-model="gugun"
                            :options="Gugunoptions"
                            value-field="item"
                            text-field="name"
                            
                            @change="getDong"
                            />
                    </div>
                   <div class="col-md-2">
                            <b-form-select
                            v-model="dong"
                            :options="Dongoptions"
                            value-field="item"
                            text-field="name"
                            />
                   </div>
                   
                   <div class="col-md-2">
                        
                            <b-form-select
                            v-model="searchType"
                            :options="searchoptions"
                            value-field="item"
                            text-field="name"
                            />
                   </div>
                   <div class="form-group">
                            <div class="input-group md-1">
                            <input class="form-control" placeholder="검색어를 입력해주세요" type="text" v-model="searchText">
                            
                            </div>
                    </div>
                   <div class="col-md-2">
                        <button type="button" class="ht-btn ht-btn-md ht-btn--circle ht-btn-xs" @click="Search">검색</button>
                    </div>
                </div>
                <div class="row portfolio-details-feature-wrap">
                    <!-- <div class="col-lg-6">
                        <div class="portfolio-details-one-images mb-30">
                            <img class="img-fluid border-radus-5" src="@/assets/img/portfolio/portfolio-01-670x479.jpg" alt="image">
                        </div>
                        <div class="portfolio-details-one-images mb-30">
                            <img class="img-fluid border-radus-5" src="@/assets/img/portfolio/portfolio-02-670x479.jpg" alt="image">
                        </div>
                        <div class="portfolio-details-one-images mb-30">
                            <img class="img-fluid border-radus-5" src="@/assets/img/portfolio/portfolio-04-670x479.jpg" alt="image">
                        </div>
                    </div> -->
                    <div class="col-lg-6 mt-5">
                        <vue-daum-map
                        :appKey="appKey"
                        :center="center"
                        :level.sync="level"
                        :mapTypeId="mapTypeId"
                        :libraries="libraries"
                        @load="onLoad"
                        style="width:100%;height:400px;"/>
                    </div>
                    <div class="col-lg-6">
                        <div class="portfolio-details-content">
                            
                            <div class="portfolio-details-table mt-30">
                                <table class="table mt-3 mr-3">
                                    <colgroup>
                                        <col width='20%'/>
                                        <col width='10%'/>
                                        <col width='20%'/>
                                        <col width='10%'/>
                                        <col width='10%'/>
                                    </colgroup>
                                    <thead class="thead-light"> 
                                        <tr>
                                            
                                            <th class="text-center">아파트명</th>
                                            <th class="text-center">동</th>
                                            <th class="text-center">건설 날짜</th>
                                            <th class="text-right">거래가격</th>
                                            <th class="text-right">상세보기</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(apart, index) in paginatedData" :key="index">
                                            
                                            <td class="text-center">{{apart.aptName}}</td>
                                            <td class="text-center">{{apart.dong}}</td>
                                            <td class="text-center">{{apart.buildYear}}</td>
                                            <td class="text-center">{{numberWithCommas(apart.dealAmount)}}원(평당)</td>
                                            <td class="td-actions text-right">
                                            <button type="button" rel="tooltip" class="ht-btn ht-btn--outline ht-btn-xs" @click="moveDetail(apart)" data-original-title="" title="">
                                                <i class="fas fa-bars"></i>
                                            </button>
                                            </td>
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
    import {mapGetters} from 'vuex';
    import VueDaumMap from 'vue-daum-map'

    export default {
        name: 'PortfolioGrid',
        components: {
            Navbar,
            HeaderElement,
            Breadcrumb,
            Footer,
            OffcanvasSearchBox,
            OffCanvasMobileMenu,
            VueDaumMap,
        },
        data(){
      return{
          appKey:'your key',
          level:3,
          center:{lat:37.50268606315912, lng:127.02663133540325},
          mapTypeId: VueDaumMap.MapTypeId.NORMAL,
        libraries: ["clusterer",'services'],
        map: null,
          pagination: {
                default: 1
            },
          pageNum:0,
          searchText:'',
          city:'서울특별시',
          gugun:'종로구',
          dong:'청운동',
          Gugunoptions:[],
          Dongoptions:[],
          searchType:'DONG',
          searchoptions:[{item:'APTNAME',name:'아파트명'},{item:'DONG',name:'동'},{item:'BUILDYEAR',name:'건설 날짜'}],
      }
  },
    props:{
        pageSize: {
        type: Number,
        required: false,
        default: 5
        }
    },
  computed:{
    ...mapGetters(['aparts',"getUserCode",]),
    pageCount () {
      let listLeng = this.aparts.length,
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
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.aparts.slice(start, end);
    }
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
    this.Gugunoptions=options 
    //관심지역이 등록되어 있다면 관심지역 동부터 보여주기
    if(this.getUserCode!=""){
        http.get(`/myapi?code=${this.getUserCode}`).then(({data})=>{
            let condition={}
            condition['dong']=data.dong;
            condition['searchType']="DONG";
            this.$store.dispatch('getMakerdata',condition)
            http.get(`/search?dong=${data.dong}&key=${condition.searchType}&word=""`)
            .then(({data})=>{
                this.addMarker(data)
            })
        })
    }
  },
  methods:{
    onLoad(map) {
      this.map = map;
    },
    Search(){
        let condition={}
        condition['dong']=this.dong;
        condition['searchType']=this.searchType;
        condition['searchText']=this.searchText;
        this.$store.dispatch('getMakerdata',condition)
        http.get(`/search?dong=${this.dong}&key=${this.searchType}&word=${this.searchText}`)
        .then(({data})=>{
            this.addMarker(data)
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
    numberWithCommas(x) {
        // 숫자의 3자리마다 ',' 찍기
        return String(x).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    moveDetail(item){
        //console.log(item)
        this.$router.push({name:'Detail',params:{aptName:item.aptName,
        dong:item.dong,
        jibun:item.jibun,
        buildYear:item.buildYear
        ,dealYear:item.dealYear,
        floor:item.floor,
        dealAmount:item.dealAmount,
        lat:item.lat,
        lng:item.lng,
        area:item.area,
        }})
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    addMarker(data){
            this.center['lat']=data[0].lat
            this.center['lng']=data[0].lng
            let positions=[]
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
            data.forEach(item => {
                let position={
                    title: item.aptName,
                    latlng: new kakao.maps.LatLng(item.lat,item.lng),
                    jibun:item.jibun,
                    price : item.dealAmount,
                    year : item.buildYear,
                    floor : item.floor,
                    item:item
                }
                positions.push(position)
            });

            //console.log(positions)
            for (var i = 0; i < positions.length; i ++) {
                if(i==200)break;
            
                // 마커 이미지의 이미지 크기 입니다
                var imageSize = new kakao.maps.Size(24, 35); 
                
                // 마커 이미지를 생성합니다    
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
                
                // 마커를 생성합니다
                let marker=new kakao.maps.Marker({
                    map: this.map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image : markerImage // 마커 이미지 
                });
                var overlay = new kakao.maps.CustomOverlay({
                    //content: content,
                    map: this.map,
                    position: marker.getPosition()       
                });
                // 마커 위에 커스텀오버레이를 표시합니다
                // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
                
                //커스텀 오버레이
                const contentNode=document.createElement('div')
                contentNode.className="wrap"
                let infoNode=document.createElement('div')
                infoNode.className="info"
                let titleNode=document.createElement('div')
                titleNode.className="title"
                titleNode.innerText=positions[i].title
                let closediv=document.createElement('div')
                closediv.className="close"
                // closediv.addEventListener("click",function(e){
                //     //alert("실행")
                //     console.log(e.target)
                //     overlay.setMap(null)
                // })
                
                titleNode.appendChild(closediv)
                infoNode.appendChild(titleNode)
                
                let BodyNode=document.createElement('div')
                BodyNode.className="body"
                let descNode=document.createElement('div')
                descNode.className="desc"
                let jibunNode=document.createElement('div')
                jibunNode.className="ellipsis"
                jibunNode.innerText=`지번 : ${positions[i].jibun}`
                descNode.appendChild(jibunNode)

                jibunNode=document.createElement('div')
                jibunNode.className="ellipsis"
                jibunNode.innerText=`가격 : ${positions[i].price}`
                descNode.appendChild(jibunNode)
    
                // jibunNode=document.createElement('div')
                // jibunNode.className="ellipsis"
                // jibunNode.innerText=`건설 날짜 : ${positions[i].year}`
                // descNode.appendChild(jibunNode)

                jibunNode=document.createElement('div')
                jibunNode.className="ellipsis"
                jibunNode.innerText=`층수 : ${positions[i].floor}`
                descNode.appendChild(jibunNode)
                
                BodyNode.appendChild(descNode)
                infoNode.appendChild(BodyNode)
                contentNode.appendChild(infoNode)
                addEventClose(closediv,overlay)
                
                addEventOpen(marker,overlay,overlay.getMap())
                overlay.setContent(contentNode)
                overlay.setMap(null)
                
            }
        function addEventClose(closediv,overlay){
            closediv.addEventListener("click",function(e){
                   // alert("실행")
                    overlay.setMap(null)
                    e.preventDefault()
            })
        }
        function addEventOpen(marker,overlay,map){
             kakao.maps.event.addListener(marker, 'click', function(e) {
                
                overlay.setMap(map);
                //e.preventDefault()
            });
        }
       
            
    }
  }
    }
</script>
<style>
.map {
  width: 100%;
  height: 400px;
}

.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
.wrap * {padding: 0;margin: 0;}
.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
.info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
.info .close:hover {cursor: pointer;}
.info .body {position: relative;overflow: hidden;}
.info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.info .link {color: #5085BB;}

</style>
