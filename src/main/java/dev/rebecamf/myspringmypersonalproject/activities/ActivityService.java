package dev.rebecamf.myspringmypersonalproject.activities;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import dev.rebecamf.myspringmypersonalproject.generics.IGenericEditService;
import dev.rebecamf.myspringmypersonalproject.generics.IGenericGetService;

@Service
public class ActivityService implements IGenericGetService<Activity>,IGenericEditService<ActivityDto,Activity> {

    ActivityRepository repository;

    public ActivityService(ActivityRepository activityRepository) {
        this.repository = activityRepository;
    }

    public List<Activity> getAll() {
        List<Activity> events = repository.findAll();
        return events;

    }

    public Activity getById(@NonNull Long id) throws Exception {

        Activity activity = repository.findById(id).orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
        return activity;
    }

    public Activity save(ActivityDto eventDto) throws Exception {
        
        try {
            Activity newEvent = Activity.builder()
                                .title(activityDto.getTitle())
                                .date(activityDto.getDate())
                                .hour(activityDto.getHour())
                                .place(activityDto.getPlace())
                                .description(activityDto.getDescription())
                                .capacity(activityDto.getCapacity())
                                .isOutstanding(activityDto.isOutstanding())
                                .build();
            repository.save(newActivity);

            Long activitiesTableQuantity = (long) repository.findAll().size();
            Activity activity = repository.findById(activitiesTableQuantity).orElseThrow( () -> new ActivityNotFoundException("Activity not found"));
            return activity;
        } catch (Exception e) {
            throw new Exception("Error al guardar en base de datos" + e.getMessage());
        }

    }

    public Activity delete(Long id) throws Exception {
        Activity activityToDelete = repository.findById(id).orElseThrow( () -> new ActivityNotFoundException("Activity does not exit"));
        repository.deleteById(id);
        return activityToDelete;
    }

    @Override
    public Activity update(ActivityDto activityDto, Long id) {
        Activity activity = repository.findById(id).orElseThrow( () -> new ActivityNotFoundException("Activity does not exist"));

        activity.setTitle(activityDto.getTitle());
        activity.setDate(activityDto.getDate());
        activity.setHour(activityDto.getHour());
        activity.setPlace(activityDto.getPlace());
        activity.setDescription(activityDto.getDescription());

        return repository.save(activity);
    }
}
