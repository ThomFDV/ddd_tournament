package use_cases.invitation;

import mock.MockTournamentRepository;
import mock.MockUserRepository;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

public class SendInvitationToJoinTournamentTest {

    private TournamentRepository tournaments;
    private UserRepository users;

    @Before
    public void init() {
        this.tournaments = new MockTournamentRepository();
        this.users = new MockUserRepository();
    }

    @Test
    public void should_send_invitation() {
        tournaments.add(new Tournament(
                "1",
                "1",
                LocalDate.of(2021, 03, 12),
                LocalDate.of(2021, 03, 13),
                4,
                5,
                "Tu vas t'amuser"
                ));
        this.users.add(new User("3"));
        this.users.add(new User("2"));
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments, users);
        String tournamentId = "1";
        Invitation sentInvitation = invitationSender.SendInvitation(tournamentId, "2", ReceiverType.USER, "3", Optional.of("Tu vas perdre"));

        Assert.assertEquals(sentInvitation.getTournament().getId(), tournamentId);
    }
}
