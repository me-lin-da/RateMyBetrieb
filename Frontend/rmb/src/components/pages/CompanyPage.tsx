import React from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";
import AddComment from "../../components/molecules/AddComment";

const CompanyPage = () => {
  const handleSubmit = (comment: string) => {
    console.log("Submitted comment:", comment);
    // Here you can add logic to submit the comment to your backend or wherever it needs to be stored
  };
  //TODO: Comments should be in rows of 3
  return (
    <div>
      <div className="container mx-auto px-4 bg-gray-400 h-full mt-10">
        <div className="flex flex-col rounded-lg">
          <Company />
          <div className="flex flex-wrap mt-5">
            <AddComment onSubmit={handleSubmit} />
          </div>
          <div className="flex flex-row flex-wrap gap-2 mt-5 rounded-lg">
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
