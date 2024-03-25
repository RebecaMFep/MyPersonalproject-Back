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
        List<Activity> activities = repository.findAll();
        return activities;

    }

    public Activity getById(@SuppressWarnings("null") @NonNull Long id) throws Exception {

        Activity activity = repository.findById(id).orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
        return activity;
    }

    @SuppressWarnings("null")
    public Activity save(ActivityDto activityDto) throws Exception {
        
        try {
            Activity newActivity = Activity.builder()
                                .name(activityDto.getName())
                                .location(activityDto.getLocation())
                                .days(activityDto.getDays())
                                .month(activityDto.getMonth())
                                .time(activityDto.getTime())
                                .range(activityDto.getRange())
                                .capacity(activityDto.getCapacity())
                                .description(activityDto.getDescription())
                                .build();
            repository.save(newActivity);

            Long activitiesTableQuantity = (long) repository.findAll().size();
            Activity activity = repository.findById(activitiesTableQuantity).orElseThrow( () -> new ActivityNotFoundException("Activity not found"));
            return activity;
        } catch (Exception e) {
            throw new Exception("Error al guardar en base de datos" + e.getMessage());
        }

    }

    @SuppressWarnings("null")
    public Activity delete(Long id) throws Exception {
        Activity activityToDelete = repository.findById(id).orElseThrow( () -> new ActivityNotFoundException("Activity does not exit"));
        repository.deleteById(id);
        return activityToDelete;
    }

    @Override
    public Activity update(ActivityDto activityDto, Long id) {
        @SuppressWarnings("null")
        Activity activity = repository.findById(id).orElseThrow( () -> new ActivityNotFoundException("Activity does not exist"));

        activity.setName(activityDto.getName());
        activity.setLocation(activityDto.getLocation());
        activity.setDays(activityDto.getDays());
        activity.setMonth(activityDto.getMonth());
        activity.setTime(activityDto.getTime());
        activity.setRange(activityDto.getRange());
        activity.setCapacity(activityDto.getCapacity());
        activity.setDescription(activityDto.getDescription());

        return repository.save(activity);
    }
}
