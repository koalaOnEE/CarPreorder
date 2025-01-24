import React from "react";
import Header from "./components/Header";
import Cover from "./components/Cover";
import PhotoGrid from "./components/PhotoGrid";
import Mid from "./components/Mid";

const Home = () => {
  return (
    <div>
      <Header />
      <Cover />
      <PhotoGrid /> 
      <Mid />
    </div>
  );
};

export default Home;
