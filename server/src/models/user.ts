export interface IUser {
  id?: string;
  name: string;
  email: string;
  password: string;
  age: number;
  country: string;
  city: string;
  image: any;
}

export interface DBUser {
  id?: string;
  name: string;
  email: string;
  password: string;
  age: number;
  country: string;
  city: string;
  imageUrl: string;
}
