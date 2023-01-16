import { useEffect, useState } from 'react';
import Product from "./Product";


const ProductList = () => {
    const [products, setProducts] = useState([]);
    const getProducts = async () => {
        setProducts(apiProducts);
    }

    useEffect(
        () => {
            getProducts();
        },
        []
    );

    return (
        <ul>
            {
                products.length > 0 ? products.map((product) =>
                    <Product key={product.id} product={product} />
                ) : "No hay productos en la tienda."
            }
        </ul>
    );
}

export default ProductList;