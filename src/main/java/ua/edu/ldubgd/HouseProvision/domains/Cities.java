package ua.edu.ldubgd.HouseProvision.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Cities {

    @Id
    @SequenceGenerator(name = "cities_sequence",
            sequenceName = "cities_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "cities_sequence")


    private Long Id;
    private String cities;

}
