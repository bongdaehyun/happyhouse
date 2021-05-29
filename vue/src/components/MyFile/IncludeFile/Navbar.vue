<template>
    <b-navbar type="light" toggleable="xl" fixed="top" v-b-scrollspy:nav-scroller class="header-area" :class="{'is-sticky': scrolled}">
        <div class="container-fluid container-fluid--cp-150">
            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
            <b-navbar-brand class="navbar-brand" to="/">
            <img :src='"@/assets/img/logo/logo-dark.png"' alt="logo">
            </b-navbar-brand>
            <!-- 로그인 안했을 경우 -->
            <b-btn-group class="header-config-wrapper">
                <b-nav-item v-if="!getAccessToken">
                    <b-link class="ht-btn ht-btn--outline hire-btn d-none d-xl-block"><router-link to="/Login">Login Now</router-link></b-link>
                </b-nav-item>
            </b-btn-group>
            <b-collapse class="default-nav justify-content-center"  is-nav id="nav_collapse" v-if="!getAccessToken">
                <b-navbar-nav class="navbar-nav main-menu">
                    <b-nav-item href="#home" class="scroll"><router-link to="/"><span>HOME</span></router-link></b-nav-item>
                    <b-nav-item href="#about" class="scroll"><router-link to="/"><span>ABOUT</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/Notice"><span>공지사항</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/QnA"><span>QnA</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/login"><span>실거래가</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/login"><span>관심지역</span></router-link></b-nav-item>
                </b-navbar-nav>
            </b-collapse>
            <b-collapse class="default-nav justify-content-center"  is-nav id="nav_collapse" v-else>
                <b-navbar-nav class="navbar-nav main-menu">
                    <b-nav-item ><router-link to="/mypage"><span>{{getUserName}}님 환영합니다</span></router-link></b-nav-item>
                    <b-nav-item href="#" @click.prevent="onClickLogout"><span>LogOut</span></b-nav-item>
                    <b-nav-item href="#home" class="scroll"><router-link to="/"><span>HOME</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/Notice"><span>공지사항</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/QnA"><span>QnA</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/List"><span>실거래가</span></router-link></b-nav-item>
                    <b-nav-item ><router-link to="/myarea"><span>관심지역</span></router-link></b-nav-item>
                </b-navbar-nav>
            </b-collapse>
            
        </div>
    </b-navbar>
</template>

<script>
import { mapGetters } from "vuex";
    export default {
        name:'Navbar',
        data (){
            return {
                load: false,
                limitPosition: 200,
                scrolled: false,
                lastPosition: 500,
            }
        },
        computed: {
        ...mapGetters(["getAccessToken", "getUserId", "getUserName"])
        },
        mounted (){
            (function() {
                scrollTo();
            })();

            function scrollTo() {
                const links = document.querySelectorAll('.scroll > a');
                links.forEach(each => (each.onclick = scrollAnchors));
            }

            function scrollAnchors(e, respond = null) {
                const distanceToTop = el => Math.floor(el.getBoundingClientRect().top);
                e.preventDefault();
                var targetID = (respond) ? respond.getAttribute('href') : this.getAttribute('href');
                const targetAnchor = document.querySelector(targetID);
                if (!targetAnchor) return;
                const originalTop = distanceToTop(targetAnchor);
                window.scrollBy({ top: originalTop, left: 0, behavior: 'smooth' });
                const checkIfDone = setInterval(function() {
                    const atBottom = window.innerHeight + window.pageYOffset >= document.body.offsetHeight - 190;
                    if (distanceToTop(targetAnchor) === 0 || atBottom) {
                        targetAnchor.tabIndex = '-1';
                        targetAnchor.focus();
                        clearInterval(checkIfDone);
                    }
                }, 800);
            }
        },
        methods: {
            // sticky menu script
            handleScroll() {
                if (this.lastPosition < window.scrollY && this.limitPosition < window.scrollY) {
                    this.scrolled = true;
                    // move up!
                } 
                if (this.lastPosition > window.scrollY) {
                    this.scrolled = true;
                    // move down
                }
                this.lastPosition = window.scrollY;
                this.scrolled = window.scrollY > 50;
            },

            // offcanvas searchbox
            toggleClass(addRemoveClass, className) {
                const el = document.querySelector('#search-overlay');
                if (addRemoveClass === 'addClass') {
                    el.classList.add(className);
                } else {
                    el.classList.remove(className);
                }
            },
            onClickLogout() {
            this.$store.dispatch("logout")
                .then(() => this.$router.replace("/")
                .catch(() => {}));
            },
        }, 
        created() {
            window.addEventListener("scroll", this.handleScroll);
        },
        destroyed() {
            window.removeEventListener("scroll", this.handleScroll);
        },
    }
</script>