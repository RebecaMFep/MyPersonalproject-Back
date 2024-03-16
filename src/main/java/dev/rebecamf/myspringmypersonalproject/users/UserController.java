package dev.rebecamf.myspringmypersonalproject.users;


import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rebecamf.myspringmypersonalproject.activities.Activity;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/activities")
    public ResponseEntity<Collection<Activity>> getActivities() {
        Collection<Activity> events = service.get();
        return ResponseEntity.ok().body(events);
    }

}
