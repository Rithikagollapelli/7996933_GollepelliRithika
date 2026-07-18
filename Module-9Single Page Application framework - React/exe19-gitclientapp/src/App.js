import React, { useState } from "react";
import GitClient from "./GitClient";

function App() {

  const [repos, setRepos] = useState([]);

  const loadRepositories = async () => {

    const data = await GitClient.getRepositories("techiesyed");

    setRepos(data);

  };

  return (
    <div style={{ padding: "20px" }}>

      <h1>GitHub Repository Viewer</h1>

      <button onClick={loadRepositories}>
        Load Repositories
      </button>

      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>

    </div>
  );

}

export default App;