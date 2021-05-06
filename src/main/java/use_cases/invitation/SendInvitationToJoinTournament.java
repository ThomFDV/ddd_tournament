package use_cases.invitation;

import model.*;

import java.util.Optional;

public class SendInvitationToJoinTournament {

    private final TournamentRepository tournaments;
    private final UserRepository users;
    private final TeamRepository teamRepository;

    public SendInvitationToJoinTournament(TournamentRepository tournaments, UserRepository userRepository, TeamRepository teamRepository) {
        this.tournaments = tournaments;
        this.users = userRepository;
        this.teamRepository = teamRepository;
    }

    public Invitation SendInvitation(
            String tournamentId,
            String receiverId,
            ReceiverType receiverType,
            String senderId,
            Optional<String> invitationMessage
    ) {
        Invitation invitation = new Invitation();
        Tournament tournament = this.tournaments.getTournament(tournamentId).get();
        invitation.setTournament(tournament);

        if (receiverType == ReceiverType.TEAM) {
            Team team = TeamRepository.getTeam(receiverId);
            invitation.setReceiver(team);
        } else {
            Optional<User> user = users.getUser(receiverId);
            invitation.setReceiver(user);
        }

        Optional<User> sender = users.getUser(senderId);
        invitation.setSender(sender.get());

        if (!invitationMessage.isPresent()) invitation.setMessage(invitationMessage.get());

        invitation.send();

        return invitation;
    }
}
