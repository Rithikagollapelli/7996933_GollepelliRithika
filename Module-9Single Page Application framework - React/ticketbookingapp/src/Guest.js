import React from "react";

function Guest() {

  const loginMessage = () => {
    alert("Please Login to Book Tickets");
  };

  return (
    <div>
      <h2>Guest Page</h2>

      <h3>Available Flights</h3>

      <button onClick={loginMessage}>
        Hyderabad → Delhi
      </button>

      <br /><br />

      <button onClick={loginMessage}>
        Hyderabad → Mumbai
      </button>

      <br /><br />

      <button onClick={loginMessage}>
        Hyderabad → Chennai
      </button>

      <br /><br />

      <p>Please Login to Book Tickets.</p>
    </div>
  );
}

export default Guest;