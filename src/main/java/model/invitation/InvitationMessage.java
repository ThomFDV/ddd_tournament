package model.invitation;

import java.util.Optional;

public class InvitationMessage {
    private final String value;

    public InvitationMessage(Optional<String> invitationMessage) {
        if(!invitationMessage.isPresent()) {
            this.value = "";
        } else {
            String message = invitationMessage.get();
            if(message.contains("bannedword")) {
                throw new IllegalArgumentException();
            }
            this.value = message;
        }

    }
}
