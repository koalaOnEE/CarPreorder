
import { useUser, RedirectToSignIn } from "@clerk/clerk-react";

// eslint-disable-next-line react/prop-types
const ProtectedRoute = ({ children }) => {
  const { isSignedIn, isLoaded } = useUser();

  // Wait until the user's state is fully loaded
  if (!isLoaded) {
    console.log("Loading user state...");
    return <div>Loading...</div>;
  }

  if (!isSignedIn) {
    console.log("User is not signed in, redirecting...");
    return <RedirectToSignIn />;
  }

  console.log("User is signed in!");
  return children;
};

export default ProtectedRoute;
