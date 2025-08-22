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
    const handleDelete = (id) => {
        commentApi.delete(`/${id}`)
            .then(() => {
            setComments(comments.filter(c => c.id !== id));
        })
            .catch(err => console.error("Error deleting comment:", err));
    }

    return (

        <ul className="comment-list">
            {comments.map((c) => (
                <li key={c.id} className="comment-item">
                    {editingId === c.id ? (
                        <>
                            <input
                                value={editContent}
                                onChange={(e) => setEditContent(e.target.value)}
                            />
                            <button className="save-btn" onClick={()=> handleSaveEdit(c.id)}>
                                Save
                            </button>
                        </>
                    ) : (
                        <>
                        <span>{c.content}</span>
                            <button className="edit-btn" onClick={() => startEditing(c)}>
                                Edit
                            </button>
                            <button className="delete-btn" onClick={() => handleDelete(c.id)}>
                                Delete
                            </button>
                        </>
                    )}
                </li>
            ))}
        </ul>
    );
}
