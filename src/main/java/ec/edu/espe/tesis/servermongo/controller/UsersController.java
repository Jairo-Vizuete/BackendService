package ec.edu.espe.tesis.servermongo.controller;

import ec.edu.espe.tesis.servermongo.dto.UsersRQ;
import ec.edu.espe.tesis.servermongo.model.Users;
import ec.edu.espe.tesis.servermongo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersRQ usersRQ){
        try {
            log.info("The user's information is: {}", usersRQ);
            this.usersService.enterUser(usersRQ);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            log.error("The user wasn't created: {}", usersRQ);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "{name}")
    public ResponseEntity getUserByName(@PathVariable("name") String name){
        try {
            Optional<Users> users = this.usersService.getUser(name);
            return ResponseEntity.ok(users);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<Users> users = this.usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
