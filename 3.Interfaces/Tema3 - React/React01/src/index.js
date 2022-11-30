import React from "react";
import ReactDOM from "react-dom/client";

const Title = ({msg})=>{
    //console.log(props)
    return <h1>{msg}</h1>
}

const Header = ()=>{
    return <Title msg="Mi página en React"/>;
}

const Footer = ()=>{
    return <p>Realizado por 2º DAM A</p>
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<div><Header/><Footer/></div>);