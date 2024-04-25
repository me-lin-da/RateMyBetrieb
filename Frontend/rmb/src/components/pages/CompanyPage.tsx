import React from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";

const CompanyPage = () => {
  return (
    <div>
      <div className="relative bg-gray-400 w-3/5 mx-auto h-full mt-10">
        <div className="flex flex-col rounded-lg">
          <Company />
          <div className="flex flex-row flex-wrap mt-10">
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
