import React, { useState } from "react";

interface MenuItem {
  label: string;
  link: string;
}

interface DropdownProps {
  items: MenuItem[];
  triggerElement: React.ReactNode;
}

const Dropdown = ({ items, triggerElement }: DropdownProps) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  const handleItemClick = () => {
    toggleDropdown();
  };

  return (
    <div className="relative inline-block text-left">
      <div onClick={toggleDropdown}>{triggerElement}</div>

      {isOpen && (
        <div className="absolute right-0 mt-2 p-0 w-24 shadow-lg bg-white ring-1 ring-opacity-5 z-50 rounded-full">
          <div className="flex-col">
            {items.map((item, index) => (
              <a href={item.link}>
                <button
                  key={index}
                  onClick={() => handleItemClick()}
                  className="block px-4 py-2 text-sm text-secondary w-full text-left bg-main hover:bg-secondary hover:text-main"
                >
                  {item.label}
                </button>
              </a>
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default Dropdown;
