import './App.css';
//a
const Header = (props) => {
  return <h1>Título: {props.title}</h1>
}

//b
const links = [
  {id:1, name:"Inicio", anchor:"http://miweb.com/inicio"}, 
  {id:2, name:"Acerca de", anchor:"http://miweb.com/acercade"},
  {id:3, name:"Pedidos", anchor:"http://miweb.com/pedidos"},
  {id:4, name:"Contáctanos", anchor:"http://miweb.com/contáctanos"}
]

const Column = (props) => {
  if (props.links) {
    return props.links.map((link) => <li key= {link.id}> {link.name}: <a href={link.anchor}>{link.anchor}</a></li>);
  }
  if(props.columna1) {
    //console.log("columna1")
    return props.columna1.map((link) => <li key= {link.id}> {link.name}: <a href={link.anchor}>{link.anchor}</a></li>);
  }
  if(props.columna2) {
    //console.log("columna2")
    return props.columna2.map((link) => <li key= {link.id}> {link.name}: <a href={link.anchor}>{link.anchor}</a></li>);
  }
  if(props.columna3) {
    //console.log("columna3")
    return props.columna3.map((link) => <li key= {link.id}> {link.name}: <a href={link.anchor}>{link.anchor}</a></li>);
  }
  
}

//c
const columna1 = [
  {id:1, name:"Ventas", anchor:"http://miweb.com/ventas"}, 
]
const columna2 = [
  {id:1, name:"Descripcion", anchor:"http://miweb.com/descripcion"}, 
]
const columna3 = [
  {id:1, name:"Finalidad", anchor:"http://miweb.com/finalidad"}, 
]

const Footer = (props) => {
  if (props.opcion1) {
    return <Column columna1={columna1}/>
  }
  if (props.opcion2) {
    return <Column columna2={columna2}/>
  }
  if (props.opcion3) {
    return <Column columna3={columna3}/>
  }
  
}

//d
const tamañoButton = (props) => {

}

//APP
const App = () => {
  return (
    <div>
      <Header title="Ejercicio 1"/>
      <br/>
      <Column links={links}/>
      <br/>
      <Footer opcion1={columna1}/>
      <Footer opcion2={columna2}/>
      <Footer opcion3={columna3}/>
    </div>
      
  );
}

export default App;
