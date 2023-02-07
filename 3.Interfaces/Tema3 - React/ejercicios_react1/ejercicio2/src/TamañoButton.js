const TamañoButton = ({size}) => {
    if (size === "pequeño") {
      return <button id='pequeño'>Pequeño</button>
    }
    if (size === "mediano") {
      return <button id='mediano'>Mediano</button>
    }
    if (size === "grande") {
      return <button id='grande'>Grande</button>
    }
  }

  export default TamañoButton;