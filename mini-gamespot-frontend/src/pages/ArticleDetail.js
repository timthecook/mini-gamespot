import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import CommentForm from "../components/CommentForm";

export default function ArticleDetail() {
    const { id } = useParams();
    const [article, setArticle] = useState(null);
    const [comments, setComments] = useState([]);

    useEffect(() => {
        api.get(`/articles/${id}`)
            .then(res => setArticle(res.data))
            .catch(err => console.error(err));
    }, [id]);

    useEffect(() => {
        api.get(`comments?articleId=${id}`)
            .then(res => setComments(res.data))
            .catch(err => console.error(err));
    },[id]);

    const handleAddComment = (newComment) => {
        api.post("/comments",{
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
            <ul>
                {comments.map(c => (
                    <li key={c.id}>{c.content}</li>
                ))}
            </ul>
                    <CommentForm onAdd={handleAddComment} />
        </div>
    );
}
