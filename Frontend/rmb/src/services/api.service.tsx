import axios from "axios";
// the api service
export function api() {
  return axios.create({
    baseURL: "http://localhost:8080",
    timeout: 3000,
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${localStorage.getItem("userAuthToken")}`,
    },
  });
}
