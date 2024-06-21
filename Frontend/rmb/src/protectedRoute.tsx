import React from "react";
import { Navigate } from "react-router-dom";
import { useAuth } from "./hooks/AuthContext";

interface ProtectedRouteProps {
  children: JSX.Element;
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ children }) => {
  const authToken = useAuth();

  console.log(authToken);

  if (!authToken) {
    console.log("DINNE");
    return <Navigate to="/Login" />;
  }

  return children;
};

export default ProtectedRoute;
