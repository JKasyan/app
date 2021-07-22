package com.example.entry.model;

import com.example.core.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingAwareUser extends User {

    @JsonProperty(value = "rating", required = true)
    private int rating;

    public RatingAwareUser(final User user, final int rating) {
        super(
                user.getId(),
                user.getName(),
                user.getDepId()
        );
        this.rating = rating;
    }
}
