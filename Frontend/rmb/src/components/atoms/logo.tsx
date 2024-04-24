import React from "react";

interface logoProps {
  photosrc?: string;
  alt?: string;
}

const Logo = ({ photosrc, alt }: logoProps) => {
  return (
    <div>
      <img
        src={photosrc}
        alt={alt}
        className={"flex items-start btn-icon max-w-80 max-h-12 m-auto"}
      />
    </div>
  );
};

export default Logo;
