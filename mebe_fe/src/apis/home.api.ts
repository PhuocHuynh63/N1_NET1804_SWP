import httpRequest from "~/constants/httpRequest";
import { Banner } from "~/interfaces/category.inter";
import { SuccessResponse } from "~/interfaces/utils.inter";

const homeApi = {
  getSlideHome : () => httpRequest.get<SuccessResponse<Banner>, any>(`/api/banner`),
}
export default homeApi;