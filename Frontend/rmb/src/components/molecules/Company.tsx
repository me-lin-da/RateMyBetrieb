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
    <div className="bg-main w-full flex flex-row p-8 gap-8 rounded-2xl">
      <div className="shrink-0">
        <img
          src={Logo}
          className="aspect-square h-96 w-auto object-contain"
          alt="elhu"
        />
      </div>
      <div className="flex flex-col">
        <h1 className="text-7xl -ml-1 text-white font-bold">Interdiscount</h1>
        <div className="text-white text-xl">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam
            veritatis expedita, architecto fugiat facilis praesentium harum
            temporibus voluptatibus eum mollitia eligendi accusamus? Cumque
            consequatur doloremque voluptatem nisi. Sequi, accusantium
            veritatis.
          </p>
        </div>
      </div>
    </div>
  );
};

export default Company;
