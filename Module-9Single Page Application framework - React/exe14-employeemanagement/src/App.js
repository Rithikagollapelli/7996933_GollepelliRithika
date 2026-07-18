import React, { useState } from "react";
import EmployeeList from "./EmployeeList";
import ThemeContext from "./ThemeContext";

function App() {

  const [theme] = useState("dark");

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management System</h1>

        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );

}

export default App;