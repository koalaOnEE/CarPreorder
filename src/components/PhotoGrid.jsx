import React from "react";
import styles from "./PhotoGrid.module.css"; // Import the CSS module

function PhotoGrid() {
  const photos = [
    {
      src: "/images/slide2.jpeg",
      title: "2025 BMW i5",
      link: "Learn More",
    },
    {
      src: "/images/slide4.jpg",
      title: "2025 BMW M4",
     
      link: "Learn More",
    },
    {
      src: "/images/photo4.jpg",
      title: "2025 BMW X3 ",
      link: "Learn More ",
    },
  ];

  return (
    <div className={styles.photoGrid}>
      {photos.map((photo, index) => (
        <div className={styles.photoCard} key={index}>
          <img src={photo.src} alt={photo.title} className={styles.photoImage} />
          <div className={styles.photoContent}>
            <h3>{photo.title}</h3>
            <p>{photo.description}</p>
            <a href="#">{photo.link}</a>
          </div>
        </div>
      ))}
    </div>
  );
}

export default PhotoGrid;
