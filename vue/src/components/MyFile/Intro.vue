<template>
    <div class="feature-slider-area section-space--pt_60">
        <div class="feature-slider position-relative">
            <div class="feature-slider__container">
                <div class="feature-slider__wrapper">
                            <div class="feature-slider__single-slide">
                                <div class="feature-slider__single-slide-wrapper">
                                    <div class="row align-items-center">
                                        
                                        <div class="col-md-6 wow move-up">
                                            <div class="content" style="float:right;">
                                                <h4 class="title">SSAFY 5기 구미 4반 도우나</h4>
                                                <ul>
                                                    <div><li>영남대학교 기계IT대학 정보통신공공학과 졸업</li></div>
                                                    <div><li>프론트 and 백 엔드 작업</li></div>
                                                    <div><li>1+1=1 팀원</li></div>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col-md-6 wow move-up">
                                            <div>
                                                <img src="@/assets/img/box-image/prof2.png" alt="">
                                            </div>
                                        </div>


                                        <div class="col-md-6 wow move-up">
                                            <div class="image">
                                                <img src="@/assets/img/box-image/prof3.png" class="img-fluid" alt="">
                                            </div>
                                        </div>
                                        <div class="col-md-6 wow move-up">
                                            <div class="content">
                                                <h4 class="title">SSAFY 5기 구미 4반 봉대현</h4>
                                                <ul>
                                                    <div><li>금오공과대학교 컴퓨터공학과 졸업</li></div>
                                                    <div><li>프론트 and 백 엔드 작업</li></div>
                                                    <div><li>1+1=1 팀장</li></div>
                                                </ul>
                                            </div>
                                        </div>
                                    
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
        name: 'featureTwo',
        data (){
            return {
                swiperOption: {
                    speed: 600,
                    loop: true,
                    slidesPerView: 1,
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    breakpoints: {
                        768:{
                            clickable: false
                        }
                    }
                }
            }
        }
    }
</script>