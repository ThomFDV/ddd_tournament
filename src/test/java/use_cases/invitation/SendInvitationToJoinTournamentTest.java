package use_cases.invitation;

import mock.MockInvitationRepository;
import mock.MockTeamRepository;
import mock.MockTournamentRepository;
import mock.MockUserRepository;
import model.*;
import model.invitation.Invitation;
import model.invitation.InvitationRepository;
import model.invitation.InvitationStatus;
import model.team.Team;
import model.team.TeamRepository;
import model.tournament.Tournament;
import model.tournament.TournamentRepository;
import model.tournament.TournamentStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

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
    public void should_send_invitation_when_we_invite_single_user() {
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

        Assert.assertEquals(sentInvitation.getStatus(), InvitationStatus.SENDED);
    }

    @Test
    public void should_send_invitation_when_we_invite_team() {
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
        Team testTeam = new Team();
        this.teams.add(testTeam);
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments, users, teams, invitations);
        Invitation sentInvitation = invitationSender.SendInvitation(tournament.getId(), testTeam.getId(), ReceiverType.TEAM, "3", Optional.of("Tu vas perdre"));

        Assert.assertEquals(sentInvitation.getStatus(), InvitationStatus.SENDED);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_not_send_invitation_when_no_sender() {
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
        Team testTeam = new Team();
        this.teams.add(testTeam);
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments, users, teams, invitations);
        Invitation sentInvitation = invitationSender.SendInvitation(tournament.getId(), testTeam.getId(), ReceiverType.TEAM, "4", Optional.of("Tu vas perdre"));
    }

    @Test(expected = NoSuchElementException.class)
    public void should_not_send_invitation_when_wrong_tournament() {
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
        Team testTeam = new Team();
        this.teams.add(testTeam);
        SendInvitationToJoinTournament invitationSender = new SendInvitationToJoinTournament(tournaments, users, teams, invitations);
        Invitation sentInvitation = invitationSender.SendInvitation(UUID.randomUUID().toString(), testTeam.getId(), ReceiverType.TEAM, "4", Optional.of("Tu vas perdre"));
    }
}
