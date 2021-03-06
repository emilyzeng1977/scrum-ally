package in.keepgrowing.scrumally.security;

import in.keepgrowing.scrumally.user.UserService;
import in.keepgrowing.scrumally.user.model.User;
import in.keepgrowing.scrumally.user.model.UserCredentials;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserService userService;
    private CustomUserDetailsService userDetailsService;

    @Before
    public void setUp() {
        userDetailsService = new CustomUserDetailsService(userService);
    }

    @Test
    public void loadsUserByUsername() {
        UserCredentials credentials = new UserCredentials("user", "start", "ROLE_ADMIN");
        User user = new User(credentials);
        given(userService.findByUsername("user"))
                .willReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("user");
        assertEquals("user", userDetails.getUsername());
        assertEquals(1, userDetails.getAuthorities().size());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void throwsExceptionWhenLoadingNonExistingUser() {
        userDetailsService.loadUserByUsername("user");
    }

    @Test
    public void exceptionMessageContainsUsername() {
        try {
            userDetailsService.loadUserByUsername("user1");
        } catch (UsernameNotFoundException e) {
            assertEquals("Username: user1 not found", e.getMessage());
        }
    }
}