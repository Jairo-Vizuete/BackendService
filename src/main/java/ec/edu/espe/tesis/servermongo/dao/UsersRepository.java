package ec.edu.espe.tesis.servermongo.dao;

import ec.edu.espe.tesis.servermongo.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByName(String name);
}
