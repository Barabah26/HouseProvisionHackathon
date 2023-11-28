package ua.edu.ldubgd.HouseProvision.domains;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class BotUser {


    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "user_sequence")


    private Long Id;
    private Long userId;
    private Long telegramId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String location;
    private int experience;
    private int houseId;



}
