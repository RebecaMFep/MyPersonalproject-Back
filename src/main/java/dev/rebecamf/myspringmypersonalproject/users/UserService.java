package dev.rebecamf.myspringmypersonalproject.users;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import dev.rebecamf.myspringmypersonalproject.activities.Activity;

@Service
public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Collection<Activity> get() {

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        User user = repository.findByUsername(auth.getName())
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));

        return user.getActivities();
    }

}
