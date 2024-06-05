import { SuccessResponse } from "./utils.inter";
import { User } from "./user.inter";

export type AuthResponse = SuccessResponse<{
    token: string;
    user: User;
}>;