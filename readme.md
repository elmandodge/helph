# HELPH NODE.JS SERVER

This is the backend server for the helph application built with Node.js

## Endpoints

### Healthcheck

``` / ```
Method : GET

### Register

``` /register ```
Method : POST
Schema :

```javascript
{      
  name: "Example Person";
  email: "example@example.com";
  password: "examplepassword";
  age: 35;
  country: "Nigeria";
  city: "Ikeja";
  image: "https://example-image.png"; 
}
```

### Login

``` /login ```
Method: POST
Schema :

```javascript
{
    email: 'example@example.com',
    password: "examplepassword"
}
```
