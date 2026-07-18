import React from "react";

function CourseDetails() {

  const courses = [
    { id: 1, course: "Java Full Stack", duration: "3 Months" },
    { id: 2, course: "React JS", duration: "2 Months" },
    { id: 3, course: "Spring Boot", duration: "2 Months" }
  ];

  return (
    <div>
      <h2>Course Details</h2>

      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <b>{course.course}</b> - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;