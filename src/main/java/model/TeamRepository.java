package model;

import java.util.Optional;

public interface TeamRepository {
    Optional<Team> getTeam(String teamId);
}
