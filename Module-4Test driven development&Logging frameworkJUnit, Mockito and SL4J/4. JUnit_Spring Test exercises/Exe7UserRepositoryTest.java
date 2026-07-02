import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class Exe7UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName_WhenUserExists_ShouldReturnMatchingUsers() {
        // Arrange
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Eve");
        
        User user2 = new User();
        user2.setId(2L);
        user2.setName("John");

        userRepository.save(user1);
        userRepository.save(user2);

        // Act
        List<User> results = userRepository.findByName("Eve");

        // Assert
        assertEquals(1, results.size(), "Should find exactly one user named Eve.");
        assertEquals("Eve", results.get(0).getName());
    }

    @Test
    public void testFindByName_WhenUserDoesNotExist_ShouldReturnEmptyList() {
        // Act
        List<User> results = userRepository.findByName("NonExistentName");

        // Assert
        assertTrue(results.isEmpty(), "Should return an empty list if no match is found.");
    }
}
