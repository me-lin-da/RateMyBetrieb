import React from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";
import AddComment from "../../components/molecules/AddComment";

const CompanyPage = () => {
  const handleSubmit = (comment: string) => {
    console.log("Submitted comment:", comment);
    // Here you can add logic to submit the comment to your backend or wherever it needs to be stored
  };
  return (
    <div>
      <div className="relative bg-gray-400 w-3/5 mx-auto h-full mt-10">
        <div className="flex flex-col rounded-lg">
          <Company />
          <div className="flex flex-row flex-wrap mt-10">
            <AddComment onSubmit={handleSubmit} />
            <Comment />
            <Comment />
            <Comment />
            <Comment />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CompanyPage;
