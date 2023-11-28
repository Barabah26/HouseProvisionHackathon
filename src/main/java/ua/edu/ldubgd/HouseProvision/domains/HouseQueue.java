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
public class HouseQueue {
    @Id
    @SequenceGenerator(name = "HouseQueue_sequence",
            sequenceName = "HouseQueue_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "HouseQueue_sequence")
    private Long Id;
    private Long userId;
    private Long numberInQueue;

    @Override
    public String toString() {
        return "Ваш номер в черзі : " + numberInQueue;
    }
}
