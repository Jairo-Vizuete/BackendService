package ec.edu.espe.tesis.servermongo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersRQ {
    private String name;
    private String profession;
}
