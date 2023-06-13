import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import HotelView from './HotelView';
import HotelForm from './HotelForm';
import './index.css'
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <App>
    <HotelView/>
    <HotelForm/>
  </App>
);

reportWebVitals();
