import { userModel as User } from "../../db/schemas/user";
import { IUser } from "../../models/user";
import { createNewUser } from "./create-user";
import { signJwt } from "../../utils/jwt";
import { comparePassword } from "../../utils/encrypt-password";
import {
  incorrectPasswordError,
  userAlreadyExistsError,
  userEmailAlreadyExistsError,
  userEmailNotFoundError,
  userNotFoundError,
} from "../../utils/error-messages";

class UserService {
  constructor() {}

  async getAllUsers() {
    return await User.find().select("-password");
  }

  private async createUser(user: IUser) {
    // Checks if user exists
    // Checks if user with email already exists
    // Creates new user
    // Returns new user

    if (user.id) {
      const existing = await User.findById(user.id);

      if (existing) throw new Error(userAlreadyExistsError);
    }

    const existingEmailUser = await User.findOne({ email: user.email });

    if (existingEmailUser) throw new Error(userEmailAlreadyExistsError);

    const newUser = await createNewUser(user);

    const newDbUser = new User(newUser);

    await newDbUser.save();

    return newDbUser;
  }

  async updateUserById(user: IUser) {
    // Updates user by ID
    if (!user.id) return;

    const existing = await this.getUser(user.id);

    if (!existing) throw new Error(userNotFoundError);

    const updated = await existing.updateOne(user);

    return updated;
  }

  async updateUserByEmail(user: IUser) {
    // Update user by email address
    const existing = await User.findOne({ email: user.email });

    if (!existing) throw new Error(userEmailNotFoundError);

    const result = await User.updateOne({ email: user.email }, user);

    return result.acknowledged;
  }

  async getUser(id: string) {
    // Finds user by ID
    const user = await User.findById(id).select("-password");

    if (!user) throw new Error(userNotFoundError);

    return user;
  }

  private async getUserByEmail(email: string) {
    // Finds user by email address
    const user = await User.findOne({ email }).select("-password");

    if (!user) throw new Error(userEmailNotFoundError);

    return user;
  }

  async registerUser(user: IUser) {
    // Creates new user and returns a token

    const newUser = await this.createUser(user);

    const token = signJwt({
      id: newUser.id,
    });

    return token;
  }

  async loginUser(email: string, password: string) {
    // Finds user with email
    // Compares user password
    // Returns a token

    const user = await User.findOne({ email });

    if (!user) throw new Error(userEmailNotFoundError);

    const isValid = await comparePassword(password, user.password);

    if (!isValid) throw new Error(incorrectPasswordError);

    const token = signJwt({ id: user.id });

    return token;
  }

  async removeUser(id: string) {
    // Finds and delete user
    // Returns deleted user

    const deleted = await User.findByIdAndDelete(id);

    if (!deleted) throw new Error(userNotFoundError);

    return deleted;
  }
}

export const userService = new UserService();
