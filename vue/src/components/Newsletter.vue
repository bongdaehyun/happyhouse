<template>
    <div class="newsletter-section section-space--ptb_120 default-bg" id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10  ml-auto mr-auto">
                    <div class="section-title-wrapper text-center section-space--mb_50 wow move-up">
                        <h3 class="section-title text-white">수 천개의 집 정보가 등록되어있어요!<br> Let's Find Your House</h3>
                    </div>
                    <!-- newsletter form -->
                    <div class="newsletter-form--one section-space--mb_20 text-center wow move-up">
                        <form action="#">
                            <input type="text" placeholder="Your name">
                            <input type="email" placeholder="Email">
                            <button class="btn btn--white btn-text-theme">Subscribe</button>
                        </form>
                    </div>
                    <!-- newsletter text -->
                    <h6 class="text-white text-center wow move-up">공지사항은 읽어보셨나요? <a class="hover-style-link hover-style-link--green"><router-link to="/Notice">Learn more</router-link></a></h6>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'newsletter'
    }
</script>