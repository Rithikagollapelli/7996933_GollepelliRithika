import React, { Component } from "react";
import Cart from "./Cart";
import CartItem from "./CartItem";

class OnlineShopping extends Component {

  constructor(props) {
    super(props);

    this.items = [
      new Cart("Laptop", 65000),
      new Cart("Smartphone", 28000),
      new Cart("Headphones", 2500),
      new Cart("Smart Watch", 5000),
      new Cart("Keyboard", 1200)
    ];
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Online Shopping Cart</h1>

        {this.items.map((item, index) => (
          <CartItem key={index} item={item} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;