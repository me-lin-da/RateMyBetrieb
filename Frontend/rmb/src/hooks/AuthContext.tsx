import React, {
  createContext,
  useContext,
  useState,
  useEffect,
  ReactNode,
} from "react";
import { Navigate } from "react-router-dom";
import { api } from "../services/api.service";

interface AuthContextType {
  authToken: string | null;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [authToken, setAuthToken] = useState<string | null>(null);

  useEffect(() => {
    const token = localStorage.getItem("userAuthToken");
    setAuthToken(token);
  }, []);

  return (
    <AuthContext.Provider value={{ authToken }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = (): string | void => {
  const context = localStorage.getItem("userAuthToken");
  if (!context) {
    return window.location.assign("/login");
  }
  return context;
};
