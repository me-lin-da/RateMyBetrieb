import { Outlet } from "react-router-dom";
import Header from "./organisms/header";
// Layout of the whole page
const Layout = () => {
  return (
    <>
      <Header />
      <main>
        <Outlet />
      </main>
    </>
  );
};
export default Layout;
