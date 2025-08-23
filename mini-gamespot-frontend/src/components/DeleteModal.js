import React from "react";

const DeleteModal = ({isOpen, onClose, onConfirm}) => {
    if (!isOpen) return null;

    return (
        <div className="modal-overlay">
            <div className="modal">
                <h3> Are you sure you want to delete this comment?</h3>
                <div className="modal-actions">
                    <button onClick={onConfirm} className="btn btn-danger">
                        Delete
                    </button>
                    <button onClick={onClose} className="btn btn-secondary">
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    );
};

export default DeleteModal;