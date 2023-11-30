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
public class ConstructionCostByRegion {

    @Id
    @SequenceGenerator(name = "constructionCostByRegion_sequence",
            sequenceName = "constructionCostByRegion_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "onstructionCostByRegion_sequence")
    private Long Id;
    private String city;
    private int cost;


}
