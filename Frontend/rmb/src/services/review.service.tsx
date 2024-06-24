import { api } from "./api.service";
// the userservice
async function getAllReviews() {
  return await api().get("/review");
}

export default { getAllReviews };
