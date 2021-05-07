package use_cases.invitation;

import model.*;
import model.invitation.Invitation;
import model.invitation.InvitationRepository;
import model.team.Team;
import model.team.TeamRepository;
import model.tournament.Tournament;
import model.tournament.TournamentRepository;

import java.util.Optional;

public class SendInvitationToJoinTournament {

    private final TournamentRepository tournaments;
    private final UserRepository users;
    private final TeamRepository teams;
    private final InvitationRepository invitation;

    public SendInvitationToJoinTournament(
            TournamentRepository tournaments,
            UserRepository userRepository,
            TeamRepository teamRepository,
            InvitationRepository invitationRepository
    ) {
        this.tournaments = tournaments;
        this.users = userRepository;
        this.teams = teamRepository;
        this.invitation = invitationRepository;
    }

    public Invitation SendInvitation(
            String tournamentId,
            String receiverId,
            ReceiverType receiverType,
            String senderId,
            Optional<String> invitationMessage
    ) {
        Tournament tournament = this.tournaments.getTournament(tournamentId).get();
        Optional<User> sender = users.getUser(senderId);
        Optional<Team> team = this.teams.getTeam(receiverId);
        Optional<User> user = users.getUser(receiverId);

        Invitation invitation = new Invitation(receiverType, invitationMessage, tournament, sender, team, user);

        this.invitation.send(invitation);

        return invitation;
    }
}
