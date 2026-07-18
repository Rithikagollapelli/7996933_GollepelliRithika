function CartItem(props) {
  return (
    <div
      style={{
        border: "1px solid #ccc",
        padding: "15px",
        margin: "10px",
        borderRadius: "8px",
        backgroundColor: "#f8dd44"
      }}
    >
      <h3>{props.item.itemName}</h3>
      <p><strong>Price:</strong> ₹{props.item.price}</p>
    </div>
  );
}

export default CartItem;