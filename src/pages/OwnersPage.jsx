import React, { useState } from "react";
import axios from "axios";
import styles from "./OwnersPage.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEnvelope, faLock } from "@fortawesome/free-solid-svg-icons";

const OwnersPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.get("/api/users/login", {
        params: { email, password },
      });
      console.log(response.data); // Log user details or handle user session here
      window.location.href = "/"; // Redirect to home/dashboard
    } catch (err) {
      setError(err.response?.data || "Login failed. Please try again.");
    }
  };

  return (
    <div className={styles.ownersPage}>
      <div className={styles.overlay}></div>
      <div className={styles.content}>
        <h1>BMW ID Login</h1>
        <form onSubmit={handleLogin} className={styles.form}>
          <div className={styles.input}>
            <FontAwesomeIcon icon={faEnvelope} />
            <input
              type="email"
              placeholder="Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className={styles.input}>
            <FontAwesomeIcon icon={faLock} />
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          {error && <p className={styles.error}>{error}</p>}
          <button type="submit" className={styles.submit}>
            Login
          </button>
        </form>
        <p>
          Don’t have a BMW ID?{" "}
          <a href="/owners/register" className={styles.registerLink}>
            Register here
          </a>
        </p>
      </div>
    </div>
  );
};

export default OwnersPage;
