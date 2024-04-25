import "./App.css";
import RMB from "./components/pages/RMB";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from "./components/Layout";

function App() {
  const router = createBrowserRouter([
    {
      element: <Layout />,
      children: [
        {
          path: "/",
          element: <RMB />,
        },
      ],
    },
  ]);

  return <RouterProvider router={router} />;
}

export default App;
