import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ArticleList from "./pages/ArticleList";
import ArticleDetail from "./pages/ArticleDetail";
import CommentsPage from "./pages/CommentsPage";
import UserProfile from "./pages/UserProfile";
import Navbar from "./components/Navbar";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<ArticleList />} />
                <Route path="/comments" element={<CommentsPage />} />
                <Route path="/articles" element={<ArticleList />} />
                <Route path="/articles/:id" element={<ArticleDetail />} />
                <Route path="/user/:id" element={<UserProfile />} />
            </Routes>
        </Router>
    );
}

export default App;
