import React, { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    const referenceNumber =
      "REF" + Math.floor(100000 + Math.random() * 900000);

    alert(
      "Complaint Submitted Successfully!\n\n" +
      "Employee Name: " +
      employeeName +
      "\nReference Number: " +
      referenceNumber
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Ticket Raising Application</h1>

      <form onSubmit={handleSubmit}>

        <label><b>Employee Name</b></label>

        <br /><br />

        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          required
          style={{ width: "300px", padding: "8px" }}
        />

        <br /><br />

        <label><b>Complaint</b></label>

        <br /><br />

        <textarea
          rows="5"
          cols="40"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          required
        />

        <br /><br />

        <button type="submit">
          Submit Complaint
        </button>

      </form>
    </div>
  );
}

export default ComplaintRegister;