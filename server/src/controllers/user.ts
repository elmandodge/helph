import { Request, Response } from "express";
import { IUser } from "../models/user";
import { userService } from "../services/user/index";

class UserController {
  async registerUser(req: Request<{}, {}, IUser, {}>, res: Response) {
    const user: IUser = req.body;

    const token = await userService.registerUser(user);

    return res.json({ accessToken: token });
  }

  async login(
    req: Request<{}, {}, { email: string; password: string }, {}>,
    res: Response
  ) {
    const { email, password } = req.body;

    const token = await userService.loginUser(email, password);

    return res.json({ accessToken: token });
  }

  async removeUser(req: Request<{ id: string }, {}, {}, {}>, res: Response) {
    const { id } = req.params;

    const deleted = await userService.removeUser(id);

    return res.send(deleted);
  }

  async updateUser(req: Request<{ id: string }, {}, IUser, {}>, res: Response) {
    const user = req.body;
    const { id } = req.params;

    if (id) {
      const updated = await userService.updateUserById({ ...user, id });

      return res.send(updated);
    }

    const updated = await userService.updateUserByEmail(user);

    return res.send(updated);
  }

  async getUser(req: Request<{ id: string }, {}, {}, {}>, res: Response) {
    const { id } = req.params;

    const user = await userService.getUser(id);

    return res.send(user);
  }

  async getAllUsers(req: Request, res: Response) {
    const users = await userService.getAllUsers();

    return res.send(users);
  }
}

export const userController = new UserController();
