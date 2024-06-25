import React from "react";

interface ButtonProps {
  onClick?: () => void;
  label?: string;
  onSubmit?: (e: any) => void;
}
// The button component
const Button = ({ onClick, label }: ButtonProps) => {
  return (
    <button
      className="w-1/5 bg-secondary text-white py-2 rounded-md hover:bg-third transition duration-300"
      onClick={onClick}
    >
      {label}
    </button>
  );
};

export default Button;
