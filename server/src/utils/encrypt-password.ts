import bcrypt from "bcrypt";

export const hashPassword = async (password: string) => {
  const saltRounds = Number(process.env.SALT_ROUNDS);
  const salt = await bcrypt.genSalt(saltRounds);
  const hash = await bcrypt.hash(password, salt);

  return hash;
};

export const comparePassword = async (password: string, hash: string) => {
  return await bcrypt.compare(password, hash);
};
