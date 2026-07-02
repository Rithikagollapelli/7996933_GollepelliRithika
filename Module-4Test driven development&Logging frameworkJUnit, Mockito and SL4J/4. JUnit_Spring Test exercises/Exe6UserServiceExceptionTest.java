import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exe6UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById_WhenUserNotFound_ShouldReturnNull() {
        // Arrange
        Long missingId = 999L;
        
        // Instruct the mock repository to return an empty Optional
        when(userRepository.findById(missingId)).thenReturn(Optional.empty());

        // Act
        User result = userService.getUserById(missingId);

        // Assert
        assertNull(result, "The service should return null when the user record does not exist in the database.");
        verify(userRepository, times(1)).findById(missingId);
    }
}
