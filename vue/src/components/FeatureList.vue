<template>
    <div class="feature-icon-list">
        <div class="row">
            <div class="col-lg-6">
                <div class="feature-icon-list__media wow move-up">
                    <img src="../assets/img/features/aeroland-feature-icon-image.png" class="img-fluid" alt="">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="feature-icon-list__content">
                    <div class="feature-icon-list-wrapper">
                        <div v-for="feature in features" :key="feature.id" class="single-feature-icon wow move-up">
                            <div class="single-feature-icon__media">
                                <img :src="feature.icon" class="img-fluid" alt="">
                            </div>
                            <div class="single-feature-icon__content">
                                <h6 class="title">{{ feature.title }}</h6>
                                <div class="text">{{ feature.desc }}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'featureList',
        data (){
            return {
                features: [
                    {
                        icon: require('../assets/img/icons/aeroland-branding-box-image-01-1.png'), 
                        title: '실거주자들의 리뷰 체크', 
                        desc: '실제 살아보지않으면 모르는 정보, 실거주자들의 생생한 이야기를 제공합니다.'
                    },
                    {
                        icon: require('../assets/img/icons/aeroland-branding-box-image-02-1.png'), 
                        title: '꼼꼼한 분석도 잊지않고', 
                        desc: '그래프와 워드 클라우드를 통해 한눈에 볼 수 있는 정보를 제공합니다.'
                    },
                    {
                        icon: require('../assets/img/icons/aeroland-branding-box-image-03-1.png'), 
                        title: '지도를 통한 주변 상권 분석까지', 
                        desc: '글로만 정보를 제공하는 것이 아닌 실제 지도를 보며 주변 상권의 위치를 확인해보세요.'
                    },
                ]
            }
        }
    }
</script>
