import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {

  test("should return repository names for techiesyed", async () => {

    axios.get.mockResolvedValue({

      data: [
        { name: "ReactProject" },
        { name: "SpringBootApp" },
        { name: "MachineLearning" }
      ]

    });

    const repositories =
      await GitClient.getRepositories("techiesyed");

    expect(repositories).toEqual([
      "ReactProject",
      "SpringBootApp",
      "MachineLearning"
    ]);

  });

});