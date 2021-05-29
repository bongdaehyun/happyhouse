import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "http://localhost:7070/happyhouse",
  headers: {
    "Content-type": "application/json"
  }
});
