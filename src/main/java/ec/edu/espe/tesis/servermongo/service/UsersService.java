package ec.edu.espe.tesis.servermongo.service;

import ec.edu.espe.tesis.servermongo.dao.UsersRepository;
import ec.edu.espe.tesis.servermongo.dto.UsersRQ;
import ec.edu.espe.tesis.servermongo.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> getUser(String name){
        Optional<Users> users = this.usersRepository.findByName(name);
        return users;
    }

    public List<Users> getAllUsers(){
        List<Users> users = this.usersRepository.findAll();
        return users;
    }

    public void enterUser(UsersRQ usersRQ){
        Users userObj = new Users();
        userObj.setName(usersRQ.getName());
        userObj.setProfession(usersRQ.getProfession());
        this.usersRepository.save(userObj);
    }
}
