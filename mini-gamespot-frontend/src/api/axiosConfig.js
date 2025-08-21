import axios from "axios";

export const articleApi = axios.create({
    baseURL: "http://localhost:8080/api/articles", // point to backend gateway/base
    headers:{ "Content-Type": "application/json" },
});

export const commentApi = axios.create({
    baseURL: "http://localhost:8081/api/comments",
    headers: {"Content-Type": "application/json"},
});
