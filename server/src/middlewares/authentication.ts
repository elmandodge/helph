import { Request, Response, NextFunction } from "express";
import { verifyJwt } from "../utils/jwt";

export const auth = (req: Request, res: Response, next: NextFunction) => {
  // Verifies the access token
  // Prevents access if not authorized
  // Allows access if authorized

  const token =
    req.headers.authorization && req.headers.authorization.split(" ")[1];

  if (!token) return res.status(401).send("User not authorized");

  const decoded = verifyJwt(token);

  if (!decoded) {
    return res.status(401).send("User not authorized");
  }

  next();
};
