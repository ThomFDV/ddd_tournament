package mock;

import model.Invitation;
import model.InvitationRepository;

import java.util.ArrayList;
import java.util.List;

public class MockInvitationRepository implements InvitationRepository {
    public List<Invitation> invitations;

    public MockInvitationRepository() {
        this.invitations = new ArrayList<>();
    }

    @Override
    public void send(Invitation invitation) {
        this.invitations.add(invitation);
    }


}
