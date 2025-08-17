import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../api/axiosConfig";

export default function ArticleDetail() {
    const { id } = useParams();
    const [article, setArticle] = useState(null);

    useEffect(() => {
        api.get(`/api/articles/${id}`)
            .then(res => setArticle(res.data))
            .catch(err => console.error(err));
    }, [id]);

    if (!article) return <p>Loading...</p>;

    return (
        <div>
            <h1>{article.title}</h1>
            <p>{article.content}</p>
            <small>Created: {article.createdAt}</small>
        </div>
    );
}
