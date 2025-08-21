import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import {articleApi, commentApi} from "../api/axiosConfig";
import CommentForm from "../components/CommentForm";
import CommentList from "../components/CommentList";

export default function ArticleDetail() {
    const { id } = useParams();
    const [article, setArticle] = useState(null);
    const [comments, setComments] = useState([]);

    useEffect(() => {
        articleApi
            .get(`/${id}`)
            .then(res => setArticle(res.data))
            .catch(err => console.error(err));
    }, [id]);

    useEffect(() => {
        commentApi.get(`?articleId=${id}`)
            .then(res => setComments(res.data))
            .catch(err => console.error(err));
    },[id]);

    const handleAddComment = (newComment) => {
        commentApi.post("",{
            content: newComment,
            articleId: id,
            userId: 1 //temp hardcode
        })
            .then(res => setComments([...comments, res.data]))
            .catch(err => console.error(err));
    };

    if (!article) return <p>Loading...</p>;

    return (
        <div>
            <h1>{article.title}</h1>
            <p>{article.content}</p>
            <small>Created: {article.createdAt}</small>

            <hr />

            <h2>Comments</h2>
            <CommentList comments={comments} setComments={setComments} />
            <CommentForm onAdd={handleAddComment} />
        </div>
    );
}
