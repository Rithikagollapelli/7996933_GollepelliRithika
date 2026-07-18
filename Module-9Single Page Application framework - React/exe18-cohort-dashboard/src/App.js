import React from "react";
import CohortData from "./Cohort";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div>
      <h1>Cohort Dashboard</h1>

      {CohortData.map((cohort, index) => (
        <CohortDetails
          key={index}
          cohort={cohort}
        />
      ))}
    </div>
  );
}

export default App;