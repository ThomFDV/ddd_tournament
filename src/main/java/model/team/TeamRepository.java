package model.team;

import java.util.Optional;

public interface TeamRepository {
    Optional<Team> getTeam(String teamId);
    void add(Team team);
}
