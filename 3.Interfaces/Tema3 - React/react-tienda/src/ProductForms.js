import { useState } from "react";

const ProductForm = () => {

    const [product, setProduct] = useState({name: "", pvp: 0});

    const postProduct = async () => {
        const response = await fetch("http://localhos/3000",{
        method: 'POST',
        headers: {'Content Type': 'application/json'},
        body: JSON.strngify(product)
    });
}

    return(
        <form>
            {product.name}{product.pvp}
            <input 
                type="text" 
                name="name" 
                value="product.name"
                onChange={(event) =>{
                    setProduct({...product, name: event.target.value});
                }}
                placeholder="nombreProducto"/>
            <input 
                type="number" 
                name="pvp" 
                value="product.pvp"
                onChange={(event) =>{
                    setProduct({...product, pvp: event.target.value});
                }}
                placeholder="10,5"/>
            <br/>
            <button onClick={postProduct}>Guardar</button>
        </form>
    )
}
export default ProductForm;