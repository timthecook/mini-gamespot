import { useState } from "react";

export default function CommentForm({onAdd}){
    const [comment, setComment] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!comment.trim()) return; //ignore empty
        onAdd(comment); // pass comment up
        setComment(""); // reset input
    };

    return(
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                className="comment-input"
                placeholder="Write a comment..."
                value={comment}
                onChange={(e) => setComment(e.target.value)}
                />
            <button type="submit">Submit</button>
        </form>
    );
}