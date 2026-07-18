import EmployeeCard from "./EmployeeCard";

function EmployeeList() {

  const employees = [
    {
      id: 1,
      name: "Rithika Goud",
      department: "IT"
    },
    {
      id: 2,
      name: "Sanjana Goud",
      department: "HR"
    },
    {
      id: 3,
      name: "Santhoshi Gupta",
      department: "Finance"
    }
  ];

  return (
    <div>
      {employees.map(emp => (
        <EmployeeCard
          key={emp.id}
          employee={emp}
        />
      ))}
    </div>
  );

}

export default EmployeeList;