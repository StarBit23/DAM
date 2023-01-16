import ProductList from "./ProductList";
import ProductForm from "./ProductForms";

const getProducts = async () => {
  const response = await fetch('http://localhost:3000/products');
  const apiProducts = await response.json();
  return apiProducts;
}

function App() {
  return (
    <div>
      <ProductList refreshProducts={refreshProducts}/>
      <ProductForm getProducts={getProducts}/>
    </div>
  );
}

export default App;
