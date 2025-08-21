import React, {useEffect, useState} from "react";
import CommentList from "../components/CommentList"
import { commentApi } from "../api/axiosConfig";

export default function CommentsPage(){
        const [comments, setComments] = useState([]);

        useEffect(() => {
            commentApi.get("/")
                .then(res => setComments(res.data))
                .catch(err => console.error(err));
        }, []);

    return(
        <div>
            <h1>Comments Page</h1>
            <CommentList comments={comments} setComments={setComments} />
        </div>
    );
}