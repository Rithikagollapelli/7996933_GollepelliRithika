import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

  constructor(props) {
    super(props);

    this.state = {
      posts: [],
      error: null
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts() {

    const reactQuestions = [
      new Post(
        1,
        "What is React?",
        "React is a JavaScript library used to build fast, reusable, and interactive user interfaces."
      ),
      new Post(
        2,
        "What is JSX?",
        "JSX is a syntax extension for JavaScript that allows you to write HTML-like code inside React components."
      ),
      new Post(
        3,
        "What are Functional Components?",
        "Functional components are simple JavaScript functions that return JSX."
      ),
      new Post(
        4,
        "What is a Class Component?",
        "A class component is an ES6 class that extends React.Component and supports lifecycle methods."
      ),
      new Post(
        5,
        "What is State in React?",
        "State stores dynamic data that can change over time and automatically updates the user interface."
      ),
      new Post(
        6,
        "What are Props?",
        "Props are read-only inputs passed from a parent component to a child component."
      ),
      new Post(
        7,
        "What is Virtual DOM?",
        "The Virtual DOM is a lightweight copy of the real DOM used by React to improve rendering performance."
      ),
      new Post(
        8,
        "What is componentDidMount()?",
        "componentDidMount() is a lifecycle method that executes after a component is rendered for the first time."
      )
    ];

    this.setState({
      posts: reactQuestions
    });
  }

  componentDidCatch(error) {
    alert("Error: " + error.message);
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>React Blog Posts</h1>

        {this.state.posts.map((post) => (
          <div
            key={post.id}
            style={{
              border: "1px solid #ddd",
              marginBottom: "15px",
              padding: "15px",
              borderRadius: "8px",
              backgroundColor: "#f8f9fa"
            }}
          >
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;