package use_cases.tournament;

import model.Tournament;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CreateTournamentTest {

    private User user;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private int nbTeams;
    private int teamSize;

    @Before
    public void init() {
        this.user = new User();
        this.startDate = LocalDate.of(2021, 05, 06);
        this.endDate = LocalDate.of(2021, 05, 07);
    }

    @Test
    public void should_return_new_tournament() {
        this.nbTeams = 4;
        this.teamSize = 5;
        this.name = "Tournament de fou";
        Tournament tournament = new CreateTournament().initiate(this.nbTeams,
                this.teamSize, this.name, this.startDate, this.endDate, this.user);
        Assert.assertEquals(tournament.getClass(), Tournament.class);
    }
}
