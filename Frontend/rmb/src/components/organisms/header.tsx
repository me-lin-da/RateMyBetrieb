import React, { useState } from "react";
import SearchBar from "../molecules/searchfield";
import Logo from "../../assets/IDLogo.jpeg";
import Account from "../../assets/Account.png";
import Dropdown from "../molecules/Dropdown";

const Header = () => {
  const OnSearch = () => {};
  const handleItemClick = () => {
    console.log("Item clicked");
  };
  const menuItems = [
    { label: "Item 1", action: handleItemClick },
    { label: "Item 2", action: handleItemClick },
    { label: "Item 3", action: handleItemClick },
  ];
  const imageTrigger = (
    <img
      src={Account}
      className="flex items-center btn-icon max-w-80 max-h-12 m-auto hover:bg-main rounded-full"
      alt="Logo"
    />
  );
  return (
    <header className="bg-secondary py-4">
      <div className="container mx-auto flex justify-between w-2/3">
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
        <Dropdown items={menuItems} triggerElement={imageTrigger} />
      </div>
    </header>
  );
};

export default Header;
