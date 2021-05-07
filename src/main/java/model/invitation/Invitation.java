package model.invitation;

import model.ReceiverType;
import model.team.Team;
import model.tournament.Tournament;
import model.User;

import java.util.Optional;
import java.util.UUID;

// Entity
public class Invitation {

    private String id;
    private Tournament tournament;
    private Object receiver;
    private User sender;
    private InvitationMessage message;
    private InvitationStatus status;

    public Invitation(ReceiverType receiverType, Optional<String> invitationMessage, Tournament tournament, Optional<User> sender, Optional<Team> team, Optional<User> user) {

        this.id = UUID.randomUUID().toString();

        this.tournament = tournament;
        if (receiverType == ReceiverType.TEAM) {
            this.receiver = team;
        } else {
            this.receiver = user;
        }
        this.sender = sender.get();

        this.message = new InvitationMessage(invitationMessage);

        this.status = InvitationStatus.CREATED;
    }

    public Tournament getTournament() {
        return this.tournament;
    }

    public InvitationStatus getStatus() {
        return this.status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }
}
