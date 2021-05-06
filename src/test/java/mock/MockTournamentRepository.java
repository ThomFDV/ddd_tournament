package mock;

import model.Tournament;
import model.TournamentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockTournamentRepository implements TournamentRepository {
    public List<Tournament> tournaments;

    public MockTournamentRepository() {
        tournaments = new ArrayList<Tournament>();
    }

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public Optional<Tournament> getTournament(String id) {
        return tournaments.stream().filter(tournament -> {
            return tournament.getId() == id;
        }).findFirst();
    }
}
