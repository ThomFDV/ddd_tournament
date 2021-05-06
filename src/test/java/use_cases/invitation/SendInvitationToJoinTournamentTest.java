package use_cases.invitation;

import mock.MockTournamentRepository;
import model.Invitation;
import model.ReceiverType;
import model.TournamentRepository;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

public class SendInvitationToJoinTournamentTest {

    private TournamentRepository tournaments;

    @Before
    public void init() {
        this.tournaments = new MockTournamentRepository();
    }

    @Test
    public void should_send_invitation() {
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments);
        Invitation sendedInvitation = invitationSender.SendInvitation("1", "2", ReceiverType.USER, "3", Optional.of("Tu vas perdre"));

        Assert.assertEquals(sendedInvitation.getClass(), Invitation.class);
    }
}
