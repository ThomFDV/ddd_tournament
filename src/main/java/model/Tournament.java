package model;

import java.time.LocalDate;

public class Tournament {

    private User admin;
    private LocalDate startDate;
    private LocalDate endDate;
    private int nbTeams;
    private int teamSize;
    private String name;

    public void setAdmin(User user) {
        this.admin = user;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setNbTeam(int nbTeams) {
        this.nbTeams = nbTeams;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {

    }
}
