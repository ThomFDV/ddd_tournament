package use_cases.invitation;

import mock.MockInvitationRepository;
import mock.MockTeamRepository;
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
    private TeamRepository teams;
    private InvitationRepository invitations;

    @Before
    public void init() {
        this.tournaments = new MockTournamentRepository();
        this.users = new MockUserRepository();
        this.teams = new MockTeamRepository();
        this.invitations = new MockInvitationRepository();
    }

    @Test
    public void should_send_invitation() {
        Tournament tournament = new Tournament(
                "1",
                LocalDate.of(2021, 03, 12),
                LocalDate.of(2021, 03, 13),
                4,
                5,
                "Tu vas t'amuser"
        );
        tournaments.add(tournament);
        this.users.add(new User("3"));
        this.users.add(new User("2"));
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments, users, teams, invitations);
        Invitation sentInvitation = invitationSender.SendInvitation(tournament.getId(), "2", ReceiverType.USER, "3", Optional.of("Tu vas perdre"));

        Assert.assertEquals(sentInvitation.getStatus(), TournamentStatus.CREATED);
    }
}
