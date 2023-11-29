package ba.sum.fsre.ednevnik.repositories;

import ba.sum.fsre.ednevnik.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
