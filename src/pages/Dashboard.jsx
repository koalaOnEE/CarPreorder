import React from "react";
import { useUser } from "@clerk/clerk-react";

const Dashboard = () => {
  const { isSignedIn, user } = useUser();

  if (!isSignedIn) {
    return <div>Please sign in.</div>;
  }

  return (
    <div>
      <h1>Welcome, {user.firstName || "User"}!</h1>
      <p>Email: {user.emailAddresses[0].emailAddress}</p>
    </div>
  );
};

export default Dashboard;
