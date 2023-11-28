package ua.edu.ldubgd.HouseProvision.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class House {
    @Id
    @SequenceGenerator(name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "house_sequence")
    private Long Id;
    private Long houseId;
    private double area;
    private int numberOfRooms;
    private double cost;
    private String location;
    private int botUserId;
    private String sourceOfFunding;
}
