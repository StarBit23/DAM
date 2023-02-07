import Column from "./Column"

const columna1 = [
    {id:1, name:"Ventas", anchor:"http://miweb.com/ventas"},
    {id:2, name:"Ventas2", anchor:"http://miweb.com/ventas2"} 
  ]
  const columna2 = [
    {id:1, name:"Descripcion", anchor:"http://miweb.com/descripcion"},
    {id:2, name:"Descripcion2", anchor:"http://miweb.com/descripcion2"} 
  ]
  const columna3 = [
    {id:1, name:"Finalidad", anchor:"http://miweb.com/finalidad"},
    {id:2, name:"Finalidad2", anchor:"http://miweb.com/finalidad2"}
  ]

const Footer = () => {
      return [<Column links={columna1}/> , <p/> , <Column links={columna2}/> , <p/> , <Column links={columna3}/>]
    
    
  }

  export default Footer;