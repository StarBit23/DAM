import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import { useEffect, useState } from "react";


const ProductList = () => {

    const [products, setProducts] = useState([]);

    const downloadProducts = async () => {
        const response = await fetch('http://localhost:8080/products');
        const products = await response.json();
        setProducts(products);
    };

    useEffect(
        () => {
            downloadProducts();
        }, 
        []
    );

    return (
        <>
            <h1>Listado de productos</h1>
            <TableContainer component={Paper}>
                <Table aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Nombre</TableCell>
                            <TableCell align="right">Precio</TableCell>
                            <TableCell align="right">Categoría</TableCell>
                            <TableCell align="right">Descripción</TableCell>
                            <TableCell align="right">Marca</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {
                            products.map((product) => {
                                return (
                                    <TableRow>
                                        <TableCell>{product.name}</TableCell>
                                        <TableCell>{product.pvp}</TableCell>
                                        <TableCell>{product.category}</TableCell>
                                        <TableCell>{product.description}</TableCell>
                                        <TableCell>{product.brand}</TableCell>
                                    </TableRow>);
                            }
                            )
                        }
                    </TableBody>
                </Table>
            </TableContainer>
        </>
    );
}

export default ProductList;