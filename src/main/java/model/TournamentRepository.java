package model;

import java.util.Optional;

public interface TournamentRepository {
    Optional<Tournament> getTournament(String tournamentId);
}
