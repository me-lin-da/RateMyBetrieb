import React, { useEffect, useState } from "react";
import Company from "../molecules/Company";
import Comment from "../molecules/Comment";
import AddComment from "../../components/molecules/AddComment";
import companyService from "../../services/companyService";
import toast from "react-hot-toast";
import reviewService from "../../services/review.service";

interface CompanyProps {
  photosrc?: string;
  alt?: string;
  companyName?: string;
  description?: string;
  rating?: number;
}

interface ReviewProps {
  id: string;
  title: string;
  text: string;
  company: CompanyProps;
  createdAt: string | null;
  createdBy: string | null;
  lastModifiedBy: string | null;
  modifiedAt: string | null;
  // Add other relevant fields
}

const CompanyPage = () => {
  const [company, setCompany] = useState<CompanyProps | null>(null);
  const [reviews, setReviews] = useState([]);

  let url: any = window.location.href;
  url = url.split("/");

  const fetchReviews = async () => {
    try {
      const response = await reviewService.getAllReviews();
      console.log("Fetched reviews:", response.data); // Log the fetched data
      setReviews(response.data);
    } catch (error) {
      console.error("Error fetching reviews:", error);
    }
  };
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
    fetchReviews();
  }, []);

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
      </div>
      {reviews.map((review: ReviewProps) => (
        <Comment
          key={review.id}
          name={review.title}
          commentText={review.text}
          rating={Math.floor(Math.random() * 10) + 1}
        />
      ))}
    </div>
  );
};

export default CompanyPage;
