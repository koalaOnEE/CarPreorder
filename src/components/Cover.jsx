import React from 'react';
import Header from "./Header"; // Import your Header component
import styles from "./Cover.module.css"; // Import Cover styles

function Cover() {
  return (
    <div className={styles.coverContainer}>
      <Header />
      <img className={styles.coverPhoto} src="/images/slide0.jpg" alt="Cover" />
      <div className={styles.textOnImage}>
        <h1>ELECTRIFY YOUR</h1>
        <h2>EXPECTATIONS.</h2>
        <p>Experience the power of BMW electric.</p>
      </div>
    </div>
  );
}

export default Cover;
