import Joi from "joi";
import { IUser, DBUser } from "../../models/user";
import { hashPassword } from "../../utils/encrypt-password";
import { getImage } from "../../utils/get-image";

const validateUser = (user: IUser) => {
  // Validates user
  // Return a validation result object

  const userSchema = Joi.object<IUser>({
    name: Joi.string().required(),
    age: Joi.number().min(13).required(),
    city: Joi.string().required(),
    country: Joi.string().required(),
    email: Joi.string().email().required(),
    id: Joi.string(),
    image: Joi.any(),
    password: Joi.string().required(),
  });

  return userSchema.validate(user, { abortEarly: false });
};

export const createNewUser = async (user: IUser) => {
  // Validates user
  // creates new user with image
  // Returns new user

  const result = validateUser(user);

  if (result.error) throw result.error;

  const newUser: DBUser = {
    ...user,
    password: await hashPassword(user.password),
    imageUrl: await getImage(user.image),
  };

  return Object.freeze<DBUser>(newUser);
};
