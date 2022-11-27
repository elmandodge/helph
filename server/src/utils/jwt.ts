import jwt from "jsonwebtoken";

const privateKey = process.env.JWT_PRIVATE_KEY as jwt.Secret;
const publicKey = process.env.JWT_PUBLIC_KEY as jwt.Secret;

export const signJwt = (payload: jwt.JwtPayload) => {
  return jwt.sign(payload, privateKey, { expiresIn: "24h" });
};

export const verifyJwt = (token: string) => {
  return jwt.verify(token, publicKey);
};
