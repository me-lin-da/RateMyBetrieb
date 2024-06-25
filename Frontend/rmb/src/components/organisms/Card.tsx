import React from "react";
import Logo from "../atoms/logo";
import Title from "../atoms/title";

interface CardProps {
  photosrc?: string;
  alt?: string;
  companyName?: string;
  description?: string;
  rating?: number;
}
// company card
const Card = ({
  photosrc,
  alt,
  companyName,
  description,
  rating,
}: CardProps) => {
  return (
    <a href={`/CompanyPage/${companyName}`}>
      <div>
        <div className="flex flex-row bg-main rounded-lg p-8">
          <Logo photosrc={photosrc} alt={alt} />
          <Title companyName={companyName} description={description} />
          <div className="m-auto items-end shrink-0">
            <p className="text-white">Rating: 7/10</p>
          </div>
        </div>
      </div>
    </a>
  );
};

export default Card;
