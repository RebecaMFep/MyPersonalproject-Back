package dev.rebecamf.myspringmypersonalproject.subscriptions;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rebecamf.myspringmypersonalproject.generics.IGenericSubscription;
import dev.rebecamf.myspringmypersonalproject.responses.Response;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class SubscriptionController {

    IGenericSubscription service;

    public SubscriptionController(IGenericSubscription service) {
        this.service = service;
    }

    @GetMapping(path = "/activities/{id}/subscription")
    public ResponseEntity<HashMap<String, String>> subscribe(@PathVariable Long id) throws Exception {

        boolean isSubscribed = service.subscribe(id);

        if (isSubscribed) {
            return ResponseEntity.ok().body(Response.getResponse("Subscription successfully"));
        }

        return ResponseEntity.status(406).body(Response.getResponse("Subscription not possible"));
    }

}

