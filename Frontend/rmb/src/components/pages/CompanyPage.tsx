import React, { useEffect, useState } from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";
import AddComment from "../../components/molecules/AddComment";
import companyService from "../../services/companyService";

const CompanyPage = () => {
  const [companies, setCompanies] = useState([]);

  const handleSubmit = (comment: string) => {
    console.log("Submitted comment:", comment);
    // Here you can add logic to submit the comment to your backend or wherever it needs to be stored
  };
  fetch("http://localhost:8080/company/all")
    .then((response) => response.json())
    .then((data) => setCompanies(data))
    .catch((error) => console.error("Error fetching users:", error));

  let comp = companyService.getAllCompany();

  console.log("sinzc companies", comp);
  //TODO: Comments should be in rows of 3
  return (
    <div className="container mx-auto px-4 bg-gray-400 h-full mt-10">
      <div className="flex flex-col rounded-lg">
        <Company />
        <div className="flex flex-wrap mt-5">
          <AddComment onSubmit={handleSubmit} />
        </div>
        <div className="flex flex-wrap gap-4 mt-5">
          <div className="flex flex-row flex-wrap rounded-lg w-1/3">
            <Comment />
          </div>
          <div className="flex flex-row flex-wrap rounded-lg w-1/3">
            <Comment />
          </div>
          <div className="flex flex-row flex-wrap rounded-lg w-1/3">
            <Comment />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CompanyPage;
