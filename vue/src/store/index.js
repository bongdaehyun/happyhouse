import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import Cookies from "js-cookie";
import http from "@/util/http-common"

Vue.use(Vuex)

//const SERVER_URL = process.env.VUE_APP_SERVER_URL; //"http://localhost:7070/vue"; //.env.local

export default new Vuex.Store({
    state: {
      accessToken: null,
      userId: "",
      userName: "",
      userCode:"",
      aparts: [],
      comments: [],
      qnas: [],
      reviews:[],
    },
    getters: {
      getAccessToken(state) {
        return state.accessToken;
      },
      getUserId(state) {
        return state.userId;
      },
      getUserName(state) {
        return state.userName;
      },
      getUserCode(state) {
        return state.userCode;
      },
      aparts(state) {
        return state.aparts;
      },
      comments(state) {
        return state.comments;
      },
      qnas(state) {
        return state.qnas;
      },
      reviews(state) {
        return state.reviews
      }
    },
    mutations: {
      LOGIN(state, payload) {
        Cookies.set("accessToken", payload["auth-token"]);
        state.accessToken = payload["auth-token"];
        state.userId = payload["user-id"];
        state.userName = payload["user-name"];
        state.userCode = payload["user-code"];
      },
      LOGOUT(state) {
        Cookies.remove("accessToken");
        state.accessToken = null;
        state.userId = "";
        state.userName = "";
        state.userCode = "";
      },
      SET_ACCESS_TOKEN(state, user){
        state.accessToken=Cookies.get("accessToken");
        state.userId=user.userid,
        state.userName = user.username;
        state.userCode = user.code
      },
      setMakers(state,payload) {
        state.aparts = payload;
      },
      setComments(state, payload) {
        state.comments = payload;
      },
      setQnas(state, payload) {
        state.comments = payload;
      },
      setCode(state, payload) {
        state.userCode = payload;
      },
      setReview(state, payload) {
        state.reviews = payload;
      }
    },
    actions: {
      login(context, user) {
        return http.post(`/user/confirm/login`, user).then((response) => {
          context.commit("LOGIN", response.data);
          axios.defaults.headers.common["auth-token"]=`${response.data["auth-token"]}`;
        });
      },
      logout(context) {
        context.commit("LOGOUT");
        axios.defaults.headers.common["auth-token"]=undefined;
        //Cookies.remove("accessToken");
      },
      signinByToken(context, accessToken){
        axios.defaults.headers.common["auth-token"]=accessToken;
        http.get(`/user/info`).then((response) => {
          context.commit("SET_ACCESS_TOKEN", response.data.user);
        });
      },
      getMakerdata(context, payload) {
        
        http.get(`/search?dong=${payload.dong}&key=${payload.searchType}&word=${payload.searchText}`)
        .then(({data})=>{
            context.commit("setMakers",data)
        })
      },
      getComments(context, payload) {
        http.get("/comment/"+payload).then(({ data }) => {
          context.commit("setComments", data);
        });
      },
      getQnas(context, payload) {
        http.get("/qna/"+payload)
        .then(({data})=>{
          context.commit("setQnas",data)
        })
      },
      getCode(context, payload) {
        context.commit("setCode",payload)
      },
      getReviews(context, payload) {
        http.get("/review/list?aptName=" + payload)
          .then(({ data }) => {
            context.commit("setReview",data)
          })
      }
    },
    modules: {
    
    }
  });
  