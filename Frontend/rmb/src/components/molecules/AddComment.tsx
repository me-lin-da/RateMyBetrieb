import React, { useState } from "react";
import Button from "../atoms/button";

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
    <div className="w-full flex flex-row bg-main rounded-2xl border-none shadow-2xl shadow-gray-800 p-8">
      <textarea
        className=" w-full h-full bg-main text-white rounded-md"
        placeholder="Add a comment..."
        value={comment}
        onChange={handleChange}
      />
      <Button onClick={handleSubmit} label={"Add Comment"} />
    </div>
  );
};

export default AddComment;
