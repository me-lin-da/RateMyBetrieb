import axios from "axios";
import { UserSingIn } from "../types/User.type";
import { api } from "./api.service";

async function login(user: UserSingIn) {
  return await await api().post("/users/login", user, {
    headers: { "Content-Type": "application/json" },
  });
}

export default { login };
