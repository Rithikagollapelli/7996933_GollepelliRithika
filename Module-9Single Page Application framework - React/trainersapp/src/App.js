import {
  BrowserRouter,
  Routes,
  Route,
  Link
} from "react-router-dom";

import Home from "./Home";
import TrainersList from "./TrainersList";
import TrainerDetails from "./TrainerDetails";

function App() {
  return (
    <BrowserRouter>

      <nav
        style={{
          display: "flex",
          gap: "20px",
          padding: "15px",
          background: "#1976d2"
        }}
      >
        <Link style={{ color: "white" }} to="/">
          Home
        </Link>

        <Link style={{ color: "white" }} to="/trainers">
          Trainers
        </Link>
      </nav>

      <Routes>

        <Route path="/" element={<Home />} />

        <Route
          path="/trainers"
          element={<TrainersList />}
        />

        <Route
          path="/trainer/:id"
          element={<TrainerDetails />}
        />

      </Routes>

    </BrowserRouter>
  );
}

export default App;