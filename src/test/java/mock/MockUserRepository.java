package mock;

import model.User;
import model.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockUserRepository implements UserRepository {
    public List<User> users;

    public MockUserRepository() { users = new ArrayList<User>();}

    public void add(User user){users.add(user);}

    @java.lang.Override
    public Optional<User> getUser(String id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }
}
