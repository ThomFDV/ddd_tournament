package mock;

import model.team.Team;
import model.team.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockTeamRepository implements TeamRepository {

    List<Team> teams;

    public MockTeamRepository() {
        this.teams = new ArrayList<>();
    }

    @Override
    public Optional<Team> getTeam(String teamId) {
        return this.teams.stream().filter(team -> team.getId() == teamId).findFirst();
    }

    @Override
    public void add(Team team) {
        this.teams.add(team);
    }
}
