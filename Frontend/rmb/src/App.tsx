import "./App.css";
import RMB from "./components/pages/RMB";
import {
  createBrowserRouter,
  Route,
  RouterProvider,
  Routes,
} from "react-router-dom";
import Layout from "./components/Layout";
import CompanyPage from "./components/pages/CompanyPage";
import Login from "./components/pages/Login";
import { useState } from "react";
import Register from "./components/pages/Register";
import ProtectedRoute from "./protectedRoute";
import { AuthProvider } from "./hooks/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route
            path="/"
            element={
              <ProtectedRoute>
                <RMB />
              </ProtectedRoute>
            }
          />
          <Route
            path="/CompanyPage"
            element={
              <ProtectedRoute>
                <CompanyPage />
              </ProtectedRoute>
            }
          />
          <Route path="/Login" element={<Login />} />
          <Route path="/Register" element={<Register />} />
        </Route>
      </Routes>
    </AuthProvider>
  );
}

export default App;
