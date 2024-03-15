package dev.rebecamf.myspringmypersonalproject.activities;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "${api-endpoint}/events")
public class ActivityController {

    ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(path = "")
    public List<Activity> index() {
        List<Activity> events = activityService.getAll();
        return events;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Activity> show(@NonNull @PathVariable("id") Long id) throws Exception {
        Activity activity = activityService.getById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(activity);
    }

    @PostMapping(path = "")
    public ResponseEntity<Activity> store(@RequestBody ActivityDto eventDto) throws Exception {
        Activity activity = activityService.save(activityDto);
        return ResponseEntity.status(201).body(activity);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Activity> destroy(@PathVariable("id") Long id) throws Exception {
        Activity deleted = activityService.delete(id);
        return ResponseEntity.accepted().body(deleted);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Activity> update(@PathVariable("id") Long id, @RequestBody ActivityDto activitytDto) {
        Activity activity = activityService.update(activitytDto, id);
        return  ResponseEntity.accepted().body(activity);
    }

}
