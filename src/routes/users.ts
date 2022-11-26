import { Router } from "express";
import { userController } from "../controllers/user";

const router = Router();

router.get("/", userController.getAllUsers);

router.get("/:id", userController.getUser);

export default router;
