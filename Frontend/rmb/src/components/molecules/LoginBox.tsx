import React, { useState } from "react";
import Button from "../atoms/button";
import userService from "../../services/userService";
import { UserSingIn } from "../../types/User.type";
import toast, { Toaster } from "react-hot-toast";

//the login box
const LoginBox: React.FC = (setToken) => {
  const [user, setUser] = useState<UserSingIn>({ email: "", password: "" });
  const [error, setError] = useState("");
  const showToast = () => toast.success("Successfully logged in");
  const showToastnegative = () => toast.error("Can't register your user");

  async function handleSubmit(e: React.SyntheticEvent) {
    e.preventDefault();

    const response = await userService.login(user);

    const authHeader = response.headers["authorization"];
    if (authHeader) {
      // Assuming the header format is "Bearer <token>"
      const token = authHeader.startsWith("Bearer ")
        ? authHeader.slice(7)
        : authHeader;
      localStorage.setItem("userAuthToken", token);
    } else {
      showToastnegative();
      throw new Error("Authorization token not found in response headers");
    }
    window.location.assign("/");
  }

  return (
    <div className="relative bg-gray-400 w-2/5 mx-auto h-full rounded-2xl border-none mt-10 shadow-2xl shadow-gray-800">
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
            value={user.email}
            onChange={(e) => setUser({ ...user, email: e.target.value })}
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
            value={user.password}
            onChange={(e) => setUser({ ...user, password: e.target.value })}
            className="w-full px-3 py-2 border rounded-md focus:border-third text-black"
          />
        </div>
        <div className="flex justify-center flex-row gap-5">
          <Button onClick={showToast} label="Login" onSubmit={handleSubmit} />
          <a href="/register" className="my-auto">
            Register
          </a>
          <Toaster />
        </div>
      </form>
    </div>
  );
};

export default LoginBox;
