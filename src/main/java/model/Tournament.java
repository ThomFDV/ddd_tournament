package model;

import java.time.LocalDate;

public class Tournament {

    private String id;
    private User admin;
    private LocalDate startDate;
    private LocalDate endDate;
    private int nbTeams;
    private int teamSize;
    private String name;

    public Tournament(String id, User admin, LocalDate startDate, LocalDate endDate, int nbTeams, int teamSize, String name) {
        this.id = id;
        this.admin = admin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nbTeams = nbTeams;
        this.teamSize = teamSize;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Tournament() {}

    public void setId(String id) {
        this.id = id;
    }

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

    public String getId() {
        return id;
    }
}
