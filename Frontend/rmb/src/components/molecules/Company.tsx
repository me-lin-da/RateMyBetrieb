import React from "react";

interface CompanyProps {
  title?: string;
  description?: string;
  rating?: number;
  logo?: string;
}
// company page
const Company = ({ title, description, rating, logo }: CompanyProps) => {
  return (
    <div className="bg-main w-full flex flex-row p-8 gap-8 rounded-2xl">
      <div className="shrink-0"></div>
      <div className="flex flex-col gap-8">
        <h1 className="text-7xl -ml-1 text-white font-bold">{title}</h1>
        <div className="text-white text-xl">
          <p>{description}</p>
          <p>Rating: 7/10</p>
        </div>
      </div>
    </div>
  );
};

export default Company;
