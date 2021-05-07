package model.tournament;

import java.time.LocalDate;
import java.util.UUID;

// Entity
public class Tournament {

    private String id;
    private String admin;
    private LocalDate startDate;
    private LocalDate endDate;
    private int nbTeams;
    private int teamSize;
    private String name;

    private TournamentStatus status;

    public Tournament(String admin, LocalDate startDate, LocalDate endDate, int nbTeams, int teamSize, String name) {
        if (nbTeams <= 0 || nbTeams % 2 != 0) {
            throw new IllegalArgumentException("Le nombre d'équipes doit être pair et supérieur à 0");
        }
        if(teamSize <= 0) {
            throw new IllegalArgumentException("La taille d'une équipe ne peut pas être nulle ou négative");
        }

        if(name.isEmpty()) {
            throw new IllegalArgumentException("Le nom du tournoi doit être renseigné");
        }

        if(startDate == null || endDate == null) {
            throw new IllegalArgumentException("Il faut renseigner la date de début et de fin du tournoi");
        }

        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La date de début ne peut pas être après la date de fin");
        }

        this.id = UUID.randomUUID().toString();
        this.admin = admin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nbTeams = nbTeams;
        this.teamSize = teamSize;
        this.name = name;

        this.status = TournamentStatus.CREATED;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return this.id;
    }

    public TournamentStatus getStatus() {
        return this.status;
    }
}
