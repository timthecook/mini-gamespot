import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import { articleApi } from "../api/axiosConfig";

export default function ArticleList(){
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        articleApi
            .get("")
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
