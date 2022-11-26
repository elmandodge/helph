import "dotenv/config";
import express from "express";
import cors from "cors";
import { connectDB } from "./db/index";
import { userController } from "./controllers/user";
import { userErrorHandler } from "./middlewares/error-handler";
import users from "./routes/users";

const app = express();

// Middlewares
app.use(cors());
app.use(express.json());

const port = process.env.PORT || 8080;

app.get("/", (req, res) => {
  // Health check

  res.send("Api is working");
});

// Register new users
app.post("/register", async (req, res, next) => {
  try {
    return await userController.registerUser(req, res);
  } catch (error) {
    next(error);
  }
});

//Login users
app.post("/login", async (req, res, next) => {
  try {
    return await userController.login(req, res);
  } catch (error) {
    next(error);
  }
});

// Routers
app.use("/users", users);

// User handler middleware
app.use(userErrorHandler);

// Connect database and start web server
connectDB()
  .then(() => {
    console.log("Connected to database");

    app.listen(port, () => console.log(`Server is listening on port: ${port}`));
  })
  .catch((err) => {
    console.error("Error connecting to database", err);
  });
