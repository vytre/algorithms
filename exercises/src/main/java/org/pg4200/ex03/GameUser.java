package org.pg4200.ex03;

import java.util.Objects;

public class GameUser {

    private String userId;

    private int points;

    public GameUser(String userId, int points) {
        this.userId = Objects.requireNonNull(userId);
        this.points = points;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public int getPoints() {
        return points;
    }

    // Setters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
