import axios from "axios";
import { UserSingIn } from "../types/User.type";

function login(user: UserSingIn) {
  return axios.post("http://localhost:8080/users/login", user, {
    headers: {
      "Content-Type": "application/json",
    },
  });
}

function register(user: UserSingIn) {
  return axios.post("http://localhost:8080/users/register", user, {
    headers: {
      "Content-Type": "application/json",
    },
  });
}

export default { login, register };
