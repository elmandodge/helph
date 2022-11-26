import mongoose from "mongoose";
import { DBUser } from "../../models/user";

const ageValidator = (age: number) => {
  return age >= 13;
};

const passwordValidator = (password: string) => {
  // TODO: make sure password follows a defined Regex pattern
  // Returns a comparison (boolean)

  return true; //To change
};

const emailValidator = (email: string) => {
  // TODO: make sure email follows a defined Regex pattern
  // Returns a comparison (boolean)

  return true; //To change
};

const userSchema = new mongoose.Schema<DBUser>({
  id: mongoose.Types.ObjectId,
  name: String,
  age: { type: Number, validate: ageValidator },
  city: String,
  country: String,
  email: { type: String, validate: emailValidator },
  imageUrl: String,
  password: {
    type: String,
    validate: passwordValidator,
  },
});

const userModel = mongoose.model("user", userSchema, "users");

export { userModel, userSchema };
