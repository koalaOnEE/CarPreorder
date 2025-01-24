import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Home from './Home';
import BYO from './BYO';
import './index.css';
import { ClerkProvider } from '@clerk/clerk-react';
import ModelsPages from "./pages/ModelsPages";
import OwnersPage from "./pages/OwnersPage";
import Dashboard from "./pages/Dashboard";
import Register from "./pages/Register";
const PUBLISHABLE_KEY = import.meta.env.VITE_CLERK_PUBLISHABLE_KEY;

if (!PUBLISHABLE_KEY) {
  throw new Error("Missing Publishable Key");
}

const router = createBrowserRouter([
  { path: "/", element: <Home /> },
  { path: "/models", element: <ModelsPages /> },
  { path: "/owners", element: <OwnersPage /> },
  { path: "/owners/register", element: <Register /> },
  { path: "/owners/dashboard", element: <Dashboard /> },
  {
    path: '/byo',
    element: <BYO />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <ClerkProvider
  publishableKey={PUBLISHABLE_KEY}
  afterSignOutUrl="/"
  options={{ debug: true }}
>
  <RouterProvider router={router} />
</ClerkProvider>

);
