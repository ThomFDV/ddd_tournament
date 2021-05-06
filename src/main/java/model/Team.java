package model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<User> users;
    private String id;

    public Team(){
        this.users = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }
}
