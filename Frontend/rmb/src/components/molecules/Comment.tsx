import React from "react";

const Comment = () => {
  return (
    <div className="flex flex-col gap-4 p-8 bg-main rounded-2xl border-none shadow-2xl shadow-gray-8008 w-1/3">
      <h1 className="text-white font-bold text-xl">Celine Sinzig</h1>
      <div className="text-white">
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta sed
          facilis commodi perspiciatis saepe, nemo, in totam repellendus
          consequatur quo eligendi, modi animi corrupti. Facilis hic asperiores
          voluptatibus distinctio necessitatibus!
        </p>
      </div>
      <p className="text-white">Rating: 10/10</p>
    </div>
  );
};

export default Comment;
