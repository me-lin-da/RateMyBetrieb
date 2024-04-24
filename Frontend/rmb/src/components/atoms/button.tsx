import React from "react";

interface ButtonProps {
  onClick?: () => void;
  label?: string;
}

const Button = ({ onClick, label }: ButtonProps) => {
  return (
    <button
      className="btn inline-flex bg-blue-900 px-4 py-2 rounded-md text-white align-middle text-center text-base font-medium tracking-wide hover:bg-blue-800 focus:outline-none focus:ring focus:ring-blue-500"
      onClick={onClick}
    >
      {label}
    </button>
  );
};

export default Button;
