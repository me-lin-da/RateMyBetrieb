import "./App.css";
import RMB from "./components/pages/RMB";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/Layout";
import CompanyPage from "./components/pages/CompanyPage";
import Login from "./components/pages/Login";
import Register from "./components/pages/Register";
import ProtectedRoute from "./protectedRoute";
import { AuthProvider } from "./hooks/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/Login" element={<Login />} />
        <Route
          path="/"
          element={
            <ProtectedRoute>
              <RMB />
            </ProtectedRoute>
          }
        />
        <Route
          path="/CompanyPage/*"
          element={
            <ProtectedRoute>
              <CompanyPage />
            </ProtectedRoute>
          }
        />
        <Route path="/Register" element={<Register />} />
      </Routes>
    </AuthProvider>
  );
}

export default App;
