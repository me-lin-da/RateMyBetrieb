import { api } from "./api.service";

async function getAllCompany() {
  return await api().get("/company");
}

export default { getAllCompany };
