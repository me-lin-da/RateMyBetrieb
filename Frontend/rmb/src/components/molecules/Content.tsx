import React from "react";
import Card from "../organisms/Card";

const Content = () => {
  return (
    <div className="relative bg-gray-400 w-3/5 mx-auto h-full rounded-2xl border-none mt-10 shadow-2xl shadow-gray-800">
      <div className="w-full align-middle bg-gray-300 p-4 pb-2 pt-2 rounded-lg">
        <Card />
      </div>
    </div>
  );
};
export default Content;
