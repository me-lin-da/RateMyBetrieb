import React from "react";
import SearchBar from "../molecules/searchfield";
import Logo from "../../assets/IDLogo.jpeg";

const Header = () => {
  const OnSearch = () => {};
  return (
    <header className="bg-gray-900 text-white py-4">
      <div className="container mx-auto flex justify-between items-center">
        <div className="flex items-center">
          <img
            src={Logo}
            className="flex items-center btn-icon max-w-80 max-h-12 m-auto"
            alt="Logo"
          />
        </div>
        <div className="flex-grow mx-8">
          <SearchBar onSearch={OnSearch} />
        </div>
        <img
          src={Logo}
          className="rounded-full items-end btn-icon max-w-80 max-h-12 m-auto"
          alt="sss"
        />
      </div>
    </header>
  );
};

export default Header;
