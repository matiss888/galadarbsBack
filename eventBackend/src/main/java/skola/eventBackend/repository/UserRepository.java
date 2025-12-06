package skola.eventBackend.repository;

import org.springframework.stereotype.Repository;

import skola.eventBackend.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameAndPassword(String name, String password);

}
