package mock;

import model.invitation.Invitation;
import model.invitation.InvitationRepository;
import model.invitation.InvitationStatus;

import java.util.ArrayList;
import java.util.List;

public class MockInvitationRepository implements InvitationRepository {
    public List<Invitation> invitations;

    public MockInvitationRepository() {
        this.invitations = new ArrayList<>();
    }

    @Override
    public void send(Invitation invitation) {
        invitation.setStatus(InvitationStatus.SENDED);
        this.invitations.add(invitation);
    }


}
