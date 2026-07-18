import React, { Component } from "react";

class LifecycleDemo extends Component {

  constructor(props) {
    super(props);

    this.state = {
      message: "Loading..."
    };
  }

  componentDidMount() {
    this.setState({
      message: "Component Loaded Successfully!"
    });
  }

  componentDidCatch(error, info) {
    console.log("Error:", error);
    console.log("Error Info:", info);

    alert("Something went wrong.");
  }

  render() {
    return (
      <div
        style={{
          width: "700px",
          margin: "40px auto",
          padding: "20px",
          border: "2px solid #1976d2",
          borderRadius: "10px",
          backgroundColor: "#f4f8ff",
          textAlign: "center"
        }}
      >
        <h1>React Component Lifecycle</h1>

        <h2>{this.state.message}</h2>

        <h3>Lifecycle Methods Demonstrated</h3>

        <ul style={{ textAlign: "left", display: "inline-block" }}>
          <li><b>componentDidMount()</b> - Executes after the component is rendered.</li>
          <li><b>componentDidCatch()</b> - Handles runtime errors gracefully.</li>
        </ul>

        <p>
          This example demonstrates how React lifecycle methods are used to
          initialize a component after rendering and to handle unexpected
          errors efficiently.
        </p>
      </div>
    );
  }
}

export default LifecycleDemo;