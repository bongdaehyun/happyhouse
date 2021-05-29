<template>
    <div class="row">
        <div v-for="item in items" :key="item.id" class="col-lg-6 col-md-12 mb-25 wow move-up">
            <div class="ht-service-box--three">
                <div class="service-box-wrap">
                    <!-- <div class="image__media">
                        <img :src="item.icon" class="img-fluid" alt="Icon">
                    </div> -->
                    <div class="content">
                        <h5 class="heading font-weight--light">{{ item.age }}</h5>
                        <!-- <div class="service_text">{{ item.desc }}</div> -->
                        <!-- <word-detail :age="item.age"></word-detail> -->
                        <bar-chart :chartdata="item.datas"></bar-chart>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    import BarChart from "@/components/MyFile/Review/barchart"
    import http from "@/util/http-common"
    export default {
        name: 'PaymentFeature',
        data (){
            return {
                items: [],
            }
        },
        components:{
             BarChart,
        },
        computed:{
            ...mapGetters(["reviews"]),
        },
        created(){
            let word="0대"
            for(let i=2;i<6;i++){
                let datas=[]
                let sum=[0,0,0,0,0]
                http.get("/review/age?age="+i+word).then(({data})=>{
                
                    data.forEach(item => {
                        sum[0]+=item.score
                        sum[1]+=item.trafficScore
                        sum[2]+=item.aroundScore
                        sum[3]+=item.careScore
                        sum[4]+=item.residentScore
                    });
                    sum.forEach(element => {
                        datas.push(parseInt(element/data.length))
                    });
                    this.items.push({
                        age:i+word,
                        datas:datas
                    })
                    
                })
            }
            // this.reviews.forEach(item => {
            //     if(item.age.includes(count+word)){
            //         lists.push(item)
            //         count++
            //     }
            // });
            // this.items=lists
        },
    }
</script>
