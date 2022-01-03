package in.as.sixtynine.rakku.dtos;

import lombok.Data;

/**
 * @Author Sanjay Das (s0d062y), Created on 02/01/22
 */

@Data
public class EntryDto {
    private Integer id;

    private Integer value;

    private Long starttime;

    private Long expirytime;

    private String type;

}
