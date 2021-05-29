<template>
    <div class="main-container">
        <!-- Navbar section -->
        <Navbar />

        <!-- hero section -->
        <HeroBranding />

        <!-- about section -->
        <div class="box-image-area section-space--ptb_120" id="about">
            <div class="container">
                <div class="section-title-wrapper text-center section-space--mb_60 wow move-up">
                    <h2 class="section-title mb-15">Happy House</h2>
                    <span class="section-text">하나뿐인 당신의 집을 Happy House와 함께 찾아보세요.</span>
                </div>
                <!-- about component -->
                <AboutExpand />
            </div>
        </div>

        <!-- business analytics start -->
        <div class="feature-icon-list-area section-space--pb_120">
            <div class="container">
                <div class="section-title-wrapper text-center section-space--mb_100">
                    <h2 class="section-title mb-30">믿을 수 있는 정보만을 제공하니까!</h2>
                    <div class="video-button-container video-popup">
                        <silentbox-single src="#">
                            <div class="video-play">
                                <i class="fa fa-play-circle"></i>
                                <span class="video-text"><router-link to="/Notice">한눈에 정보 보러가기</router-link></span>
                            </div>
                        </silentbox-single>
                    </div>
                </div>
            </div>
            <!-- feature list component -->
            <FeatureList />
        </div>


        <Intro />

        <CurveShape>
            <template v-slot:bgcolor>
                <path style="fill: #f6f5f9;
                    stroke-miterlimit:10;" 
                    d="M3360.5,97.739c-242,0-480-48.375-480-48.375
                        S2647.5,0.5,2400.5,0.5s-480,48.375-480,48.375s-238,48.864-480,48.864s-480-48.375-480-48.375S727.5,0.5,480.5,0.5
                        S0.5,48.875,0.5,48.875V108h1920h1920V48.875C3840.5,48.875,3602.5,97.739,3360.5,97.739z"/>
            </template>
        </CurveShape>


        <!-- newsletter section -->
        <Newsletter /> 

        <!-- footer section -->
        <Footer />

        <!-- offcanvas search component -->
        <OffcanvasSearchBox />

    </div>
</template>

<script>
    import Navbar from '@/components/MyFile/IncludeFile/Navbar'
    import HeroBranding from '@/components/HeroBranding'
    import AboutExpand from '@/components/AboutExpand'
    import FeatureList from '@/components/FeatureList'
    import RequireList from '@/components/RequireList'
    import FeatureTwo from '@/components/FeatureTwo'
    import ProgressCircle from '@/components/ProgressCircle'
    import CurveShape from '@/components/CurveShape'
    import Pricing from '@/components/Pricing'
    import BrandLogo from '@/components/BrandLogo'
    import Newsletter from '@/components/Newsletter'
    import Footer from '@/components/MyFile/IncludeFile/Footer'
    import Intro from '@/components/MyFile/Intro'
    import OffcanvasSearchBox from '@/components/OffcanvasSearchBox'

    export default {
        name: 'app',
        components: {
            Navbar,
            HeroBranding,
            AboutExpand,
            FeatureList,
            RequireList,
            FeatureTwo,
            ProgressCircle,
            CurveShape,
            Pricing,
            BrandLogo,
            Newsletter,
            Footer,
            Intro,
            OffcanvasSearchBox
        }
    }
</script>