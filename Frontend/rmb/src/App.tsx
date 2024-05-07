import "./App.css";
import RMB from "./components/pages/RMB";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from "./components/Layout";
import CompanyPage from "./components/pages/CompanyPage";
import Login from "./components/pages/Login";
import { useState } from "react";

function App() {
  // const [token, setToken] = useState();

  // if (!token) {
  //   return <Login setToken={setToken} />;
  // }
  const router = createBrowserRouter([
    {
      element: <Layout />,
      children: [
        {
          path: "/",
          element: <RMB />,
        },
        {
          path: "/CompanyPage",
          element: <CompanyPage />,
        },
        {
          path: "/Login",
          element: <Login />,
        },
      ],
    },
  ]);

  return <RouterProvider router={router} />;
}

export default App;
