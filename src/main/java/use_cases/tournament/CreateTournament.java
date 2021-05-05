package use_cases.tournament;

import model.Tournament;

public class CreateTournament {
    public Tournament initiate(int nbTeams, String tournamentName, LocalDate startDate, LocalDate endDate, User admin){
        Tournament tournament = new Tournament();
        tournament.setAdmin(admin);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setNbTeam(nbTeams);
        tournament.save();

        return tournament;
    }
}
