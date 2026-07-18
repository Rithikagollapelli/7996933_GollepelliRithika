import React, { useContext, useState } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  const [showDetails, setShowDetails] = useState(false);

  return (
    <div
      style={{
        border: "1px solid gray",
        margin: "15px",
        padding: "20px"
      }}
    >
      <h2>{employee.name}</h2>
      <p>Department: {employee.department}</p>

      <button
        className={theme}
        onClick={() => setShowDetails(!showDetails)}
      >
        {showDetails ? "Hide Details" : "View Details"}
      </button>

      {showDetails && (
        <div style={{ marginTop: "10px" }}>
          <p><strong>Employee ID:</strong> {employee.id}</p>
          <p><strong>Name:</strong> {employee.name}</p>
          <p><strong>Department:</strong> {employee.department}</p>
        </div>
      )}
    </div>
  );
}

export default EmployeeCard;