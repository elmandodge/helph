import jwt from "jsonwebtoken";

const secretKey = process.env.JWT_SECRET_KEY as jwt.Secret;

export const signJwt = (payload: jwt.JwtPayload) => {
  return jwt.sign(payload, secretKey);
};

export const verifyJwt = (token: string) => {
  return jwt.verify(token, secretKey);
};
