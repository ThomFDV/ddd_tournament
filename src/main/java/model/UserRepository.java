package model;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUser(String id);
    void add(User user);
}
