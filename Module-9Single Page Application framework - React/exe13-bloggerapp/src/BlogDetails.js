import React from "react";

function BlogDetails() {

  const blogs = [
    { id: 1, title: "React Basics", writer: "Rithika" },
    { id: 2, title: "Java Collections", writer: "Sanjana" },
    { id: 3, title: "Spring Boot Guide", writer: "Santhoshi" }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            <b>{blog.title}</b> - {blog.writer}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;