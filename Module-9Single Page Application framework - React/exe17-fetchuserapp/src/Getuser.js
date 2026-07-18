import React, { Component } from "react";

class Getuser extends Component {

  constructor(props) {
    super(props);

    this.state = {
      user: null
    };
  }

  componentDidMount() {
    fetch("https://api.randomuser.me/")
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          user: data.results[0]
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {

    const { user } = this.state;

    if (!user) {
      return <h2>Loading...</h2>;
    }

    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Random User Details</h1>

        <img
          src={user.picture.large}
          alt="User"
          style={{
            borderRadius: "50%",
            width: "150px",
            height: "150px"
          }}
        />

        <h2>
          {user.name.title} {user.name.first}
        </h2>
      </div>
    );
  }
}

export default Getuser;