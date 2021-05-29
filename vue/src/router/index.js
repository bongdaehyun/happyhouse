import Home from '../components/MyFile/Home'
import NotFound from '../components/MyFile/404'

import qna from '../components/MyFile/QnA/qna'
import qnaDetail from '../components/MyFile/QnA/qnaDetail'
import qnaWrite from '../components/MyFile/QnA/qnaWrite'
import qnaModify from '../components/MyFile/QnA/qnaModify'

import notice from '../components/MyFile/Notice/notice'
import noticeDetail from '../components/MyFile/Notice/noticeDetail'
import noticeWrite from '../components/MyFile/Notice/noticeWrite'
import noticeModify from '../components/MyFile/Notice/noticeModify'

import List from '../components/MyFile/List/List'
import Detail from '../components/MyFile/List/ListDetail'

import area from '../components/MyFile/area/area'

import Login from '../components/MyFile/User/Login'
import Join from '../components/MyFile/User/Join'
import mypage from '../components/MyFile/User/Mypage'
import store from "../store"

const requireAuth = () => (to, from, next) => {
    const nextRoute = to.path;
    if (store.getters.getAccessToken) {
      return next();
    } else {
      next("/login" + nextRoute);
    }
};
  
export const routes = [
    {
        path:'/login',
        name: 'Login',
        component: Login 
    },
    {
        path:'/join',
        name: 'Join',
        component: Join 
    },
    {
        path:'/mypage',
        name: 'mypage',
        component: mypage,
        beforeEnter:requireAuth()
    },
    {
        path:'/',
        name: 'Home',
        component: Home
    }, //메인 홈페이지
    {
        path:'/qna',
        name: 'qna',
        component: qna
    },//큐엔에이 리스트 페이지
    {
        path:'/qnaDetail',
        name: 'qnaDetail',
        component: qnaDetail
    },//큐엔에이 게시글 페이지
    {
        path:'/qnaWrite',
        name: 'qnaWrite',
        component: qnaWrite
    },//큐엔에이 게시글 작성 페이지
    {
        path:'/qnaModify',
        name: 'qnaModify',
        component: qnaModify
    },//큐엔에이 게시글 수정 페이지

    {
        path:'/notice',
        name: 'notice',
        component: notice
    },//공지사항 리스트 페이지
    {
        path:'/noticeDetail',
        name: 'noticeDetail',
        component: noticeDetail
    },//공지사항 게시글 페이지
    {
        path:'/noticeWrite',
        name: 'noticeWrite',
        component: noticeWrite
    },//공지사항 게시글 작성 페이지
    {
        path:'/noticeModify',
        name: 'noticeModify',
        component: noticeModify
    },//공지사항게시글 수정 페이지
    {
        path:'/list',
        name: 'list',
        component: List,
        beforeEnter:requireAuth()
    },//실거래가 검색 페이지
    {
        path:'/listDetail',
        name: 'Detail',
        component: Detail,
        beforeEnter:requireAuth()
    },//실거래가 검색 페이지
    {
        path:'/myarea',
        name: 'area',
        component: area,
        beforeEnter:requireAuth()
    },//관심지역등록
    {
        path:'*',
        name: 'NotFound',
        component: NotFound
    },
];