import React from "react";
import styles from "./Mid.module.css"; // Import Mid styles
import { Link } from 'react-router-dom'
function Mid() {
  return (
    <div className={styles.MidContainer}>
      <img className={styles.MidPhoto} src="/images/i7.avif" alt="BMW 7" />
      <div className={styles.textOnImage}>
        <h1>BMW 7 Series</h1>
        <p>Witness luxury and comfort.</p>
      
        <Link to="/Models">Learn more</Link>
        
      </div>
    </div>
  );
}

export default Mid;
