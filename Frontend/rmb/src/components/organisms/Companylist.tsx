import React, { useEffect, useState } from "react";
import axios from "axios";
import Card from "./Card";
import companyService from "../../services/companyService";
interface Company {
  photosrc?: string;
  alt?: string;
  companyName?: string;
  description?: string;
  rating?: number;
}
//companylist page

const CompanyList = () => {
  const [companies, setCompanies] = useState<Company[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchCompanies = async () => {
      try {
        const response = await companyService.getAllCompany();
        console.log("sinzc response", response);
        setCompanies(response.data);
        console.log("sinzc", response.data);
      } catch (err) {
        setError("Failed to fetch companies");
      } finally {
        setLoading(false);
      }
    };

    fetchCompanies();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div className="flex flex-col gap-3">
      {companies.map((company, index) => (
        <Card
          key={index}
          photosrc={company.photosrc}
          alt={company.alt}
          companyName={company.companyName}
          description={company.description}
          rating={company.rating}
        />
      ))}
    </div>
  );
};

export default CompanyList;
