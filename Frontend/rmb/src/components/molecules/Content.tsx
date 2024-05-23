import React from "react";
import Card from "../organisms/Card";
import CompanyList from "../organisms/Companylist";

const Content = () => {
  return (
    <div className="relative bg-gray-400 w-3/5 mx-auto h-full rounded-2xl border-none mt-10 shadow-2xl shadow-gray-800">
      <CompanyList />
    </div>
  );
};
export default Content;
