package model;

import java.util.Optional;

public class Invitation {

    private Tournament tournament;
    private Object receiver;
    private User sender;
    private String message;
    public Invitation(ReceiverType receiverType, Optional<String> invitationMessage, Tournament tournament, Optional<User> sender, Optional<Team> team, Optional<User> user) {
        this.tournament = tournament;
        if (receiverType == ReceiverType.TEAM) {
            this.receiver = team;
        } else {
            this.receiver = user;
        }
        this.sender = sender.get();

        if (!invitationMessage.isPresent()) {
            this.message = invitationMessage.get();
        }
    }

    public void send() {

    }

    public Tournament getTournament() {
        return this.tournament;
    }

}
