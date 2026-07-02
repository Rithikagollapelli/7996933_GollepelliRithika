import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional // Rolls back database modifications after each test execution
public class Exe4UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    private Long savedUserId;

    @BeforeEach
    public void setUp() {
        // Prepare persistent state directly inside the test database context
        User integrationUser = new User();
        integrationUser.setId(100L); // Or rely on your generation strategy
        integrationUser.setName("Charlie");
        
        User savedUser = userRepository.save(integrationUser);
        this.savedUserId = savedUser.getId();
    }

    @Test
    public void testFullFlow_GetExistingUser_ShouldReturnFromDatabase() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/users/{id}", savedUserId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedUserId))
                .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
