import React from "react";
import { SignUp } from "@clerk/clerk-react";
import axios from "axios";

const Register = () => {
  const handleAfterSignUp = async (user) => {
    try {
      // Send user details to your backend to register in the database
      await axios.post("/api/users/register", {
        name: user.firstName + " " + user.lastName,
        email: user.primaryEmailAddress?.emailAddress,
        password: "placeholder", // Add a default password or generate it securely
      });
      console.log("User registered in the database.");
      window.location.href = "/"; // Redirect to home after signup
    } catch (err) {
      console.error("Error registering user in the backend:", err);
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Register Your BMW ID</h1>
      <div style={{ maxWidth: "400px", margin: "0 auto" }}>
        <SignUp
          path="/owners/register"
          routing="path"
          signInUrl="/owners"
          redirectUrl="/"
          afterSignUp={handleAfterSignUp} // Handle database registration after signup
        />
      </div>
    </div>
  );
};

export default Register;
