package mock;

import model.tournament.Tournament;
import model.tournament.TournamentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockTournamentRepository implements TournamentRepository {
    public List<Tournament> tournaments;

    public MockTournamentRepository() {
        tournaments = new ArrayList<Tournament>();
    }

    @Override
    public void add(Tournament tournament) {
        tournaments.add(tournament);
    }

    @Override
    public Optional<Tournament> getTournament(String id) {
        return tournaments.stream().filter(tournament -> tournament.getId() == id).findFirst();
    }

    @Override
    public void save(Tournament tournament) {

    }
}
