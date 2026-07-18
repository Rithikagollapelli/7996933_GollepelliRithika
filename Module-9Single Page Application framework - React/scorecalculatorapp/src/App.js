import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Rithika"
        College="MRECW"
        Total={450}
        goal={5}
      />
    </div>
  );
}

export default App;