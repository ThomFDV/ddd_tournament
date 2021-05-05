package use_cases.invitation;

import model.Invitation;
import model.Team;
import model.Tournament;
import model.User;

import java.util.Optional;

public class SendInvitationToJoinTournament {
    public Invitation SendInvitation(
            String tournamentId,
            String receiverId,
            Enum receiverType,
            String senderId,
            Optional<String> invitationMessage
    ) {
        Invitation invitation = new Invitation();
        Tournament tournament = TournamentRepository.getTournament(tournamentId);
        invitation.setTournament(tournament);

        if (receiverType == Enum.TEAM) {
            Team team = TeamRepository.getTeam(receiverId);
            invitation.setReceiver(team);
        } else {
            User user = UserRepository.getUser(receiverId);
            invitation.setReceiver(user);
        }

        User sender = UserRepository.getUser(senderId);
        invitation.setSender(sender);

        if (!invitationMessage.isPresent()) invitation.setMessage(invitationMessage.get());

        invitation.send();

        return invitation;
    }
}
