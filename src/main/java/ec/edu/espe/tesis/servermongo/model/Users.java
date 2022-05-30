package ec.edu.espe.tesis.servermongo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users_01")
/*@Builder*/
public class Users {
    @Id
    private String id;
    private String name;
    private String profession;
}
