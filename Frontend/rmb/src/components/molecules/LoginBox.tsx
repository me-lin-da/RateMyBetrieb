import React, { useState } from "react";
import Button from "../atoms/button";

const LoginBox: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (username === "admin" && password === "password") {
      console.log("Login successful");
      setError("");
    } else {
      setError("Invalid username or password");
    }
  };
  return (
    <div className="relative bg-gray-400 w-1/5 mx-auto h-full rounded-2xl border-none mt-10 shadow-2xl shadow-gray-800">
      <form
        onSubmit={handleSubmit}
        className="bg-main text-white p-8 rounded-lg shadow-md"
      >
        <h2 className="text-2xl mb-4">Login</h2>
        {error && (
          <div className="w-3/5 rounded-md bg-third p-1.5 h-full">{error}</div>
        )}
        <div className="mb-4">
          <label htmlFor="username" className="block mb-1">
            Username
          </label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="w-full px-3 py-2 border rounded-md focus:border-third text-black"
          />
        </div>
        <div className="mb-4">
          <label htmlFor="password" className="block mb-1">
            Password
          </label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full px-3 py-2 border rounded-md focus:border-third text-black"
          />
        </div>
        <div className="flex justify-center">
          <Button label="Login" onSubmit={handleSubmit} />
        </div>
      </form>
    </div>
  );
};

export default LoginBox;
