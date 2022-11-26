import mongoose from "mongoose";

const dbUrl = process.env.DB_URL as string;

export const connectDB = () => {
  try {
    return mongoose.connect(dbUrl);
  } catch (error: any) {
    throw new Error(error);
  }
};
