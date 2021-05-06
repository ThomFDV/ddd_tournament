package use_cases.tournament;

import model.Tournament;
import model.TournamentRepository;
import model.User;

import java.time.LocalDate;

public class CreateTournament {
    private TournamentRepository tournaments;

    public CreateTournament(TournamentRepository tournamentRepository) {
        this.tournaments = tournamentRepository;
    }

    public Tournament initiate(int nbTeams, int teamSize, String tournamentName, LocalDate startDate, LocalDate endDate, User admin){

        if (nbTeams <= 0 || nbTeams % 2 != 0) {
            throw new IllegalArgumentException("Le nombre d'équipes doit être pair et supérieur à 0");
        }
        if(teamSize <= 0) {
            throw new IllegalArgumentException("La taille d'une équipe ne peut pas être nulle ou négative");
        }

        if(tournamentName.isEmpty()) {
            throw new IllegalArgumentException("Le nom du tournoi doit être renseigné");
        }

        if(startDate == null || endDate == null) {
            throw new IllegalArgumentException("Il faut renseigner la date de début et de fin du tournoi");
        }

        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La date de début ne peut pas être après la date de fin");
        }

        Tournament tournament = new Tournament();
        tournament.setAdmin(admin);
        tournament.setName(tournamentName);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setNbTeam(nbTeams);
        tournament.setTeamSize(teamSize);
        this.tournaments.save(tournament);

        return tournament;
    }
}
