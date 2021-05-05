package use_cases.tournament;

import model.Tournament;
import model.User;

import java.time.LocalDate;

public class CreateTournament {
    public Tournament initiate(int nbTeams, int teamSize, String tournamentName, LocalDate startDate, LocalDate endDate, User admin){
        Tournament tournament = new Tournament();
        tournament.setAdmin(admin);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setNbTeam(nbTeams);
        tournament.setTeamSize(teamSize);
        tournament.save();

        return tournament;
    }
}
