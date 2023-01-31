import './App.css';
import Header from './Header';
import Column from './Column';
import Footer from './Footer';
import TamañoButton from './TamañoButton'

const links = [
  {id:1, name:"Inicio", anchor:"http://miweb.com/inicio"}, 
  {id:2, name:"Acerca de", anchor:"http://miweb.com/acercade"},
  {id:3, name:"Pedidos", anchor:"http://miweb.com/pedidos"},
  {id:4, name:"Contáctanos", anchor:"http://miweb.com/contáctanos"}
]

//APP
const App = () => {
  return (
    <div>
      <Header title="Ejercicio 1"/>

      <br/>
      
      <Column links={links}/>

      <br/>

      <Footer/>
      
      <TamañoButton size="pequeño"/>
      <p/>
      <TamañoButton size="mediano"/>
      <p/>
      <TamañoButton size="grande"/>
    </div>
      
  );
}

export default App;
