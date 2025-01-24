import React, { useEffect, useState } from "react";
import { axiosInstance } from "../api/axios";
import { useUser, SignInButton } from "@clerk/clerk-react"; // Import Clerk components
import styles from "./ModelsPages.module.css";

const ModelsPage = () => {
  const [vehicles, setVehicles] = useState([]);
  const [error, setError] = useState(null);
  const { isSignedIn } = useUser(); // Use Clerk's `useUser` hook to check authentication status

  useEffect(() => {
    axiosInstance
      .get("/vehicles")
      .then((response) => {
        setVehicles(response.data);
      })
      .catch((error) => {
        setError("Failed to load vehicles.");
        console.error(error);
      });
  }, []);

  const filteredVehicles = vehicles.filter((vehicle) =>
    ["X3", "X5", "iX", "2 Series", "4 Series", "7 Series"].includes(vehicle.model)
  );

  const handlePurchase = (vehicleModel) => {
    if (isSignedIn) {
      alert(`Thank you for purchasing the ${vehicleModel}! A confirmation email will be sent shortly.`);
      // Add additional backend logic for purchase if needed
    }
  };

  return (
    <div className={styles.modelsPage}>
      <h1>All 2025 Models</h1>
      {error && <p className={styles.error}>{error}</p>}
      <div className={styles.cardContainer}>
        {filteredVehicles.map((vehicle) => (
          <div className={styles.card} key={vehicle.vehicleId}>
            <img
              src={`/images/${vehicle.model.replaceAll(" ", "").toLowerCase() === "ix" ? "iX" : vehicle.model.replaceAll(" ", "").toLowerCase()}.jpg`}
              alt={vehicle.model}
              className={styles.cardImage}
            />
            <div className={styles.cardContent}>
              <h2 className={styles.modelTitle}>{vehicle.model}</h2>
              <p className={styles.detail}>Price: ${vehicle.price.toFixed(2)}</p>
              <p className={styles.detail}>Engine: {vehicle.engine}</p>
              <p className={styles.detail}>
                Transmission: {vehicle.transmission || "N/A"}
              </p>
              {isSignedIn ? (
                <button
                  className={styles.purchaseButton}
                  onClick={() => handlePurchase(vehicle.model)}
                >
                  Purchase
                </button>
              ) : (
                <SignInButton mode="modal">
                  <button className={styles.signInButton}>Purchase now</button>
                </SignInButton>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ModelsPage;
