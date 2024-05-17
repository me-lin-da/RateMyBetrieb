import { api } from "./api.service";

async function getAllCompany() {
  return await await api().get("/company", {
    headers: { Authorization: `${localStorage.getItem("userAuthToken")}` },
  });
}

export default { getAllCompany };
