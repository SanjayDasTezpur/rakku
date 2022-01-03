package in.as.sixtynine.rakku.entities;

import lombok.Data;

import javax.persistence.*;

import static in.as.sixtynine.rakku.constants.DBConstants.ENTRY_DB_NAME;


@Table(name = ENTRY_DB_NAME)
@Entity
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private Integer value;

    @Column
    private Long starttime;

    @Column
    private Long expirytime;

    @Column
    private String type;

}
