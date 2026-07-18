import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
  const average = props.Total / props.goal;

  return (
    <div className="container">
      <h1>Student Management Portal</h1>

      <p><strong>Name:</strong> {props.Name}</p>

      <p><strong>College:</strong> {props.College}</p>

      <p><strong>Total Marks:</strong> {props.Total}</p>

      <p><strong>Subjects:</strong> {props.goal}</p>

      <p><strong>Average Score:</strong> {average}</p>
    </div>
  );
}

export default CalculateScore;