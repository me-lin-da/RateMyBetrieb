import React, {
  createContext,
  useContext,
  useState,
  useEffect,
  ReactNode,
} from "react";

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

  //   const login = (token: string) => {
  //     setAuthToken(token);
  //     localStorage.setItem("userAuthToken", token);
  //   };

  //   const logout = () => {
  //     setAuthToken(null);
  //     localStorage.removeItem("userAuthToken");
  //   };

  console.log(authToken);

  return (
    <AuthContext.Provider value={{ authToken }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = (): string => {
  const context = localStorage.getItem("userAuthToken");
  console.log(AuthContext);
  if (!context) {
    throw new Error("useAuth must be used within an AuthProvider");
  }
  return context;
};
