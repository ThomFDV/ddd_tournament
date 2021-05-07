package use_cases.tournament;

import model.Tournament;
import model.TournamentRepository;
import model.User;

import java.time.LocalDate;
import java.util.UUID;

public class CreateTournament {
    private TournamentRepository tournaments;

    public CreateTournament(TournamentRepository tournamentRepository) {
        this.tournaments = tournamentRepository;
    }

    public Tournament initiate(int nbTeams, int teamSize, String tournamentName, LocalDate startDate, LocalDate endDate, User admin) throws IllegalArgumentException {
        String adminId = admin.getId();

        Tournament tournament = new Tournament(adminId, startDate, endDate, nbTeams, teamSize, tournamentName);
        this.tournaments.save(tournament);
        return tournament;
    }
}
