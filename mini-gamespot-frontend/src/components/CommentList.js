import React, {useState} from "react";
import {commentApi} from "../api/axiosConfig";
import DeleteModal from "./DeleteModal";

export default function CommentList({comments, setComments}) {
    const [editingId, setEditingId] = useState(null);
    const [editContent, setEditContent] = useState("");
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [selectedCommentId, setSelectedCommentId] = useState(null);

    if (!comments || comments.length === 0) {
        return <p>No comments yet.</p>;
    }

    const startEditing = (comment) => {
        setEditingId(comment.id);
        setEditContent(comment.content);
    };

    const handleSaveEdit = (id) => {
        commentApi.put(`/${id}`, {content: editContent})
            .then(res => {
                setComments(comments.map(c => c.id === id ? res.data : c));
                setEditingId(null);
            })
            .catch(err => console.error(err));
    };
    const deleteComment = (id) => {
        commentApi.delete(`/${id}`)
            .then(() => {
                setComments(comments.filter(c => c.id !== id));
            })
            .catch(err => console.error("Error deleting comment:", err));
    }

    const handleDeleteClick = (commentId) => {
        setSelectedCommentId(commentId);
        setIsModalOpen(true);
    };

    const confirmDelete = () => {
        deleteComment(selectedCommentId);
        setIsModalOpen(false);
    };

    return (
        <>
        <ul className="comment-list">
            {comments.map((c) => (
                <li key={c.id} className="comment-item">
                    {editingId === c.id ? (
                        <>
                            <input
                                value={editContent}
                                onChange={(e) => setEditContent(e.target.value)}
                            />
                            <button className="save-btn" onClick={() => handleSaveEdit(c.id)}>
                                Save
                            </button>
                        </>
                    ) : (
                        <>
                            <span>{c.content}</span>
                            <button className="edit-btn" onClick={() => startEditing(c)}>
                                Edit
                            </button>
                            <button className="delete-btn"
                                    onClick={() => handleDeleteClick(c.id)}
                            >
                                Delete
                            </button>
                        </>
                    )}
                </li>
            ))}
        </ul>

    <DeleteModal
        isOpen={isModalOpen}
        onClose={() => setIsModalOpen(false)}
        onConfirm={confirmDelete}
    />
</>
);
}
