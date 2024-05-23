import React, { useEffect, useState } from "react";
import axios from "axios";
import Card from "./Card";

interface Company {
  photosrc?: string;
  alt?: string;
  company_name?: string;
  description?: string;
  rating?: number;
}


const CompanyList = () => {
    const [companies, setCompanies] = useState<Company[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
  
    useEffect(() => {
      const fetchCompanies = async () => {
        try {
          const response = await axios.get("http://localhost:8080/company");
          setCompanies(response.data);
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
      <div>
        {companies.map((company, index) => (
          <Card
            key={index}
            photosrc={company.photosrc}
            alt={company.alt}
            companyName={company.company_name}
            description={company.description}
            rating={company.rating}
          />
        ))}
      </div>
    );
  };
  
  export default CompanyList;