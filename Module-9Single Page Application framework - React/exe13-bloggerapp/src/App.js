import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div style={{ padding: "20px" }}>
      <h1>Blogger Application</h1>

      {showBooks && <BookDetails />}

      <hr />

      {showBlogs ? <BlogDetails /> : <p>No Blogs Available</p>}

      <hr />

      {showCourses ? <CourseDetails /> : null}

    </div>
  );
}

export default App;