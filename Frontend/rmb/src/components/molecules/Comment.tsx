import React from "react";

interface CommentProps {
  name?: string;
  commentText?: string;
  rating?: number;
}
// comment card
const Comment = ({ name, commentText, rating }: CommentProps) => {

  return (
    <div className="flex flex-col p-8 bg-main rounded-2xl border-none shadow-2xl shadow-gray-8008">
      <h1 className="text-white font-bold text-xl">{name}</h1>
      <div className="text-white">
        <p>{commentText}</p>
      </div>
      <p className="text-white">Rating: {rating}/10</p>
    </div>
  );
};

export default Comment;
