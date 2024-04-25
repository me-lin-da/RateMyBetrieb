import React from "react";
import Company from "../molecules/Company";

const CompanyPage = () => {
  return (
    <div>
      {" "}
      <div className="relative bg-gray-400 w-3/5 mx-auto h-full rounded-2xl border-none mt-10 shadow-2xl shadow-gray-800">
        <div className="flex flex-row bg-main rounded-lg">
          <Company />
        </div>
      </div>
    </div>
  );
};

export default CompanyPage;
