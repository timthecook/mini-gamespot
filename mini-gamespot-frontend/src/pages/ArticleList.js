import {useEffect, useState} from "react";
import api from "../api/axiosConfig";
import {Link} from "react-router-dom";

export default function ArticleList(){
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        api.get("/articles")
            .then(res => setArticles(res.data))
            .catch(err => console.error(err));
    }, []);

    return(
        <div>
            <h1>Articles</h1>
            <ul>{articles.map(article => (
                <li key={article.id}>
                    <Link to={`/articles/${article.id}`}>{article.title}</Link>
                </li>
            ))}
            </ul>
        </div>
    )
}
