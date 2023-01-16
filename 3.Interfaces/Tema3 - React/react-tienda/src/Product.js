import './product.css';

const Product = ({product}) => {
    const {name, pvp} = product;
    return (
        <div className="product__product">
            <h3 className="product__name">{name}</h3>
            <p className="product__pvp">PVP: {pvp}</p>
        </div>
    );
}
export default Product;