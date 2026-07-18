import React from "react";

function CohortDetails(props) {
  const { cohort } = props;

  if (!cohort) {
    return <h3>No Cohort Available</h3>;
  }

  return (
    <div
      style={{
        border: "1px solid gray",
        padding: "20px",
        margin: "20px",
        borderRadius: "8px"
      }}
    >
      <h3>{cohort.code}</h3>

      <p>
        <strong>Technology:</strong> {cohort.technology}
      </p>

      <p>
        <strong>Trainer:</strong> {cohort.trainer}
      </p>

      <p>
        <strong>Start Date:</strong> {cohort.startDate}
      </p>

      <p>
        <strong>Status:</strong> {cohort.currentStatus}
      </p>

      <p>
        <strong>Coach:</strong> {cohort.coach}
      </p>
    </div>
  );
}

export default CohortDetails;