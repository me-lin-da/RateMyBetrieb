import React from "react";
import SearchBar from "../molecules/searchfield";
import Logo from "../../assets/IDLogo.jpeg";
import Account from "../../assets/Account.png";
import Dropdown from "../molecules/Dropdown";

const Header = () => {
  const OnSearch = () => {};

  const menuItems = [
    { label: "Register", link: "/register" },
    { label: "Log In", link: "/login" },
  ];
  const imageTrigger = (
    <img
      src={Account}
      className="flex items-center btn-icon max-w-80 max-h-12 m-auto duration-300 hover:bg-main rounded-full"
      alt="Logo"
    />
  );
  // the header
  return (
    <header className="bg-secondary py-4">
      <div className="container mx-auto flex justify-between">
        <div className="flex items-center">
          <a href="/">
            <img
              src={Logo}
              className="flex items-center btn-icon max-w-80 max-h-12 m-auto"
              alt="Logo"
            />
          </a>
        </div>
        <div className="flex-grow mx-8">
          <SearchBar onSearch={OnSearch} />
        </div>
        <Dropdown items={menuItems} triggerElement={imageTrigger} />
      </div>
    </header>
  );
};

export default Header;
