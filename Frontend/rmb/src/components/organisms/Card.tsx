import React from "react";
import Logo from "../atoms/logo";
import Title from "../atoms/title";
import Rating from "../atoms/rating";

interface CardProps {
  photosrc?: string;
  alt?: string;
  companyName?: string;
  description?: string;
  rating?: number;
}

const Card = ({
  photosrc,
  alt,
  companyName,
  description,
  rating,
}: CardProps) => {
  return (
    <div>
      <div className="flex flex-row bg-main">
        <Logo photosrc={photosrc} alt={alt} />
        <Title companyName={companyName} description={description} />
        <div className="m-auto items-end">
          <p className="text-white">
            Rating: <Rating rating={rating} /> /10
          </p>
        </div>
      </div>
    </div>
  );
};

export default Card;