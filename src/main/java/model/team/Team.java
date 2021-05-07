package model.team;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<User> users;
    private String id;
    private TeamStatus status;

    public Team(){
        this.users = new ArrayList<>();
        this.status = TeamStatus.CREATED;
    }

    public String getId() {
        return this.id;
    }
}
