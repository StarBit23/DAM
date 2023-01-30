import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import PanelPrincipal from './components/PanelPrincipal';
import Help from './components/Help';
import ProductList from './components/ProductList';
import ProductForm from './components/ProductForm';
import Error from './components/Error';

const router = createBrowserRouter([
  {
    path: "/",
    element: <PanelPrincipal />,
    errorElement: <Error/>,
    children: [
      {
        index: true,
        element: <ProductList/>
      },
      {
        path: 'alta',
        element: <ProductForm />
      },
      {
        path: "ayuda",
        element: <Help />
      }
    ]
  },
]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
