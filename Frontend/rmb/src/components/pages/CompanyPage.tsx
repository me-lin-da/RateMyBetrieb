import React, { useEffect, useState } from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";
import AddComment from "../../components/molecules/AddComment";
import companyService from "../../services/companyService";
import toast from "react-hot-toast";

interface CompanyProps {
  photosrc?: string;
  alt?: string;
  companyName?: string;
  description?: string;
  rating?: number;
}

const CompanyPage = () => {
  const [company, setCompany] = useState<CompanyProps | null>(null);
  let url: any = window.location.href;
  url = url.split("/");

  useEffect(() => {
    const fetchCompanies = async () => {
      try {
        const response = await companyService.getAllCompany();
        const filteredCompanies = response.data.filter(
          (e: CompanyProps) => e.companyName === url[4]
        );

        if (filteredCompanies.length > 0) {
          setCompany(filteredCompanies[0]);
        } else {
          toast.error("Company not found");
        }
      } catch (error) {
        console.error("Failed to fetch companies", error);
        toast.error("Failed to fetch companies");
      }
    };

    fetchCompanies();
  }, [url]);

  const handleSubmit = (comment: string) => {
    console.log("Submitted comment:", comment);
  };

  if (!company) {
    return null;
  }

  return (
    <div className="container mx-auto px-4 bg-gray-400 h-full mt-10">
      <div className="flex flex-col rounded-lg">
        <Company
          title={company.companyName}
          description={company.description}
        />
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
