package dev.rebecamf.myspringmypersonalproject.subscriptions;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import dev.rebecamf.myspringmypersonalproject.activities.Activity;
import dev.rebecamf.myspringmypersonalproject.activities.ActivityService;
import dev.rebecamf.myspringmypersonalproject.generics.IGenericSubscription;
import dev.rebecamf.myspringmypersonalproject.users.User;
import dev.rebecamf.myspringmypersonalproject.users.UserNotFoundException;
import dev.rebecamf.myspringmypersonalproject.users.UserRepository;

@Service
public class SubscriptionService implements IGenericSubscription {

    ActivityService activityService;
    UserRepository userRepository;

    public SubscriptionService(ActivityService activityService, UserRepository userRepository) {
        this.activityService = activityService;
        this.userRepository = userRepository;
    }

    public boolean subscribe(Long eventId) throws Exception {

        // recuperar el evento
        Activity activity = activityService.getById(activityId);
        
        // recuperar el usuario
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        User user = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));
        
        // descontamos 1 de capacidad
        if (activity.getCapacity() != 0) {
            // asignar el evento al usuario
            Collection<Activity> activities = user.getActivities();
            activities.add(activity);
            user.setActivities(activities);
            userRepository.save(user);
            activity.setCapacity(activity.getCapacity() - 1);
            return true;
        }

        return false;
    }

}
