import React, { useState } from "react";
import { commentApi } from "../api/axiosConfig";


export default function CommentList({ comments, setComments }) {
    const [editingId, setEditingId] = useState(null);
    const [editContent, setEditContent] = useState("");

    if (!comments || comments.length === 0) {
        return <p>No comments yet.</p>;
    }

    const startEditing = (comment) => {
        setEditingId(comment.id);
        setEditContent(comment.content);
    };

    const handleSaveEdit = (id) => {
        commentApi.put(`/${id}`, { content: editContent })
            .then(res => {
                setComments(comments.map(c => c.id === id ? res.data : c));
                setEditingId(null);
            })
            .catch(err => console.error(err));
    };

    return (
        <ul>
            {comments.map((c) => (
                <li key={c.id}>
                    {editingId === c.id ? (
                        <>
                            <input
                                value={editContent}
                                onChange={(e) => setEditContent(e.target.value)}
                            />
                            <button onClick={() => handleSaveEdit(c.id)}>Save</button>
                        </>
                    ) : (
                        <>
                            {c.content}
                            <button onClick={() => startEditing(c)}>Edit</button>
                        </>
                    )}
                </li>
            ))}
        </ul>
    );
}
