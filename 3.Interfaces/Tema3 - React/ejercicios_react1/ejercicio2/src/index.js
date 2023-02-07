import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Header from './Header';
import Column from './Column';
import TamañoButton from './TamañoButton';
import reportWebVitals from './reportWebVitals';
import Footer from './Footer';



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<App>
<Header/>
<Column/>
<Footer/>
<TamañoButton/>
</App>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
