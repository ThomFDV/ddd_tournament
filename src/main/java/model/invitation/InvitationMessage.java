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

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        InvitationMessage im = (InvitationMessage) obj;
        return im.getValue().equals(this.getValue());
    }
}
