import React, { useState } from "react";

interface AddCommentProps {
  onSubmit: (comment: string) => void;
}

const AddComment = ({ onSubmit }: AddCommentProps) => {
  const [comment, setComment] = useState<string>("");

  const handleChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    setComment(e.target.value);
  };

  const handleSubmit = () => {
    onSubmit(comment);
    setComment("");
  };

  return (
    <div className="w-full flex flex-row bg-main rounded-2xl border-none shadow-2xl shadow-gray-800 p-10 m-1">
      <textarea
        className=" w-full h-full bg-main text-white rounded-2xl"
        placeholder="Add a comment..."
        value={comment}
        onChange={handleChange}
      />
      <button
        className="bg-secondary text-black rounded-2xl duration-300 hover:bg-third"
        onClick={handleSubmit}
      >
        Add Comment
      </button>
    </div>
  );
};

export default AddComment;
