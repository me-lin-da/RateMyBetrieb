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
    <div className="flex flex-col">
      <div className="flex flex-row">
        <img
          src={Logo}
          alt="ss"
          className="max-w-80 max-h-50 items-start m-auto"
        />
        <div className="flex flex-col m-auto w-full gap-8">
          <h1 className="text-9xl text-white font-bold">interdiscount</h1>
          <p className="text-white">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta sed
            facilis commodi perspiciatis saepe, nemo, in totam repellendus
            consequatur quo eligendi, modi animi corrupti. Facilis hic
            asperiores voluptatibus distinctio necessitatibus!
          </p>
          <p className="text-white">Ratings</p>
        </div>
      </div>
    </div>
  );
};

export default Company;
