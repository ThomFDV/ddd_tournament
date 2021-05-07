package model.tournament;

import java.util.Optional;

public interface TournamentRepository {
    Optional<Tournament> getTournament(String tournamentId);
    void add(Tournament tournament);
    void save(Tournament tournament);
}
