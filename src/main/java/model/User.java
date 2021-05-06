package model;

public class User {
    private String id;

    public User(String userId) {
        this.id = userId;
    }

    public User() {
    }

    public String getId() {
        return this.id;
    }
}
