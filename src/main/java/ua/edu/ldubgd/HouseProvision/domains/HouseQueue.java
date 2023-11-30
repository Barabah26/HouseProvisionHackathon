package ua.edu.ldubgd.HouseProvision.domains;

import com.vdurmont.emoji.EmojiParser;
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
    private Long numberInQueue;
    private Long telegramId;
    private String data;

    @Override
    public String toString() {
        return EmojiParser.parseToUnicode("\uD83C\uDFE2" + "Ваш номер в черзі: " + numberInQueue) + "\n\n"
                + EmojiParser.parseToUnicode("\uD83D\uDCC5" + "Дата постановки на чергу: " + data);
    }
}
