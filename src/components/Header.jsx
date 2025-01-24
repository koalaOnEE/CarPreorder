import React from "react";
import styles from "./Header.module.css";
import { Link } from "react-router-dom";
import { useUser, SignInButton } from "@clerk/clerk-react";
import { Button } from "./ui/button";

function Header() {
  const { user } = useUser();

  return (
    <header className={styles.header}>
      {/* Logo */}
      <div className={styles.logo}>
 
        <img src="/images/bmw.png" alt="BMW Logo" />
      </div>

      {/* Navigation */}
      <nav className={styles.nav}>
        <ul>
        
          <li>
            <Link to="/models">Models</Link>
          </li>
          <li>
            <Link to="/owners">Owners</Link>
          </li>
          <li>
            <Link to="/byo">Build Your Own</Link>
          </li>
          <li>
            <SignInButton>
              <Button>Sign In</Button>
            </SignInButton>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default Header;
