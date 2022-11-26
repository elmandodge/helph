import { NextFunction, Request, Response } from "express";
import Joi from "joi";

import {
  incorrectPasswordError,
  userAlreadyExistsError,
  userEmailAlreadyExistsError,
  userEmailNotFoundError,
  userNotFoundError,
} from "../utils/error-messages";

export const userErrorHandler = (
  err: Error,
  req: Request,
  res: Response,
  next: NextFunction
) => {
  if (
    err.message === userNotFoundError ||
    err.message === userEmailNotFoundError
  ) {
    res.status(404);
    res.json({ error: err.message });
  } else if (
    err.message === userAlreadyExistsError ||
    err.message === userEmailAlreadyExistsError ||
    err.message === incorrectPasswordError ||
    err instanceof Joi.ValidationError
  ) {
    res.status(400);
    res.json({ error: err.message });
  } else {
    next(err);
  }
};
