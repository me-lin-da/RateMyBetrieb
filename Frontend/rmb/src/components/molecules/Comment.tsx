import React from "react";

const Comment = () => {
  return (
    <div className="flex flex-col w-1/3">
      <div className="flex flex-row bg-main rounded-2xl border-none shadow-2xl shadow-gray-800 p-10 m-1">
        <div className="flex flex-col m-auto w-full gap-4">
          <h1 className="text-white font-bold text-xl">Celine Sinzig</h1>
          <p className="text-white truncate">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta sed
            facilis commodi perspiciatis saepe, nemo, in totam repellendus
            consequatur quo eligendi, modi animi corrupti. Facilis hic
            asperiores voluptatibus distinctio necessitatibus!
          </p>
          <p className="text-white">Rating: 10/10</p>
        </div>
      </div>
    </div>
  );
};

export default Comment;
