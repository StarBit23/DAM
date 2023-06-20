const ListadoMuseo = (props) => {

    return (
      <ul>
        {props.museos.map((museo) => 
        <li key= {museo.id}> 
          <h1>{museo.name}</h1>
          <h2>Location: {museo.location}</h2> 
          <h2>Municipio: {museo.municipality}</h2>
          <h2>Web: {museo.web}</h2>
          <img src={museo.image}></img>
        </li>)}
      </ul>
    );
};

export default ListadoMuseo;