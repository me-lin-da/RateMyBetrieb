import React from "react";
import Logo from "../../assets/IDLogo.jpeg";

interface CompanyProps {
  title?: string;
  description?: string;
  rating?: number;
  logo?: string;
}

//const Company = ({ title, description, rating }: CompanyProps) => {
const Company = () => {
  return (
    <div className="flex flex-col bg-main rounded-2xl border-none shadow-2xl shadow-gray-800">
      <div className="flex flex-row">
        <img
          src={Logo}
          alt="ss"
          className="max-w-80 max-h-50 items-start m-10"
        />
        <div className="flex flex-col m-auto w-full gap-8 mr-10">
          <h1 className="text-9xl text-white font-bold -ml-2">Interdiscount</h1>
          <p className="text-white truncate">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta sed
            facilis commodi perspiciatis saepe, nemo, in totam repellendus
            consequatur quo eligendi, modi animi corrupti. Facilis hic
            asperiores voluptatibus distinctio necessitatibus!
          </p>
          <p className="text-white">Rating: 10/10 (200)</p>
        </div>
      </div>
    </div>
  );
};

export default Company;
