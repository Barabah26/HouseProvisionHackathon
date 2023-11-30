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
public class House {
    @Id
    @SequenceGenerator(name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "house_sequence")
    private Long Id;
    private double area;
    private int numberOfRooms;
    private double cost;
    private String location;
    private Long telegramId;
    private String sourceOfFunding;
    private String data;

    @Override
    public String toString() {
        return EmojiParser.parseToUnicode(
                "\uD83C\uDFE2" + "Ваше житло:" + "\n\n"
                + "⬜"  + "Площа: " + area + " м.кв" + "\n\n"
                +  "\uD83D\uDD22"  + "Кількість кімнат: " + numberOfRooms + "\n\n"
                + "🪙" + "Вартість: " + cost + " грн" + "\n\n"
                + "\uD83D\uDDFA\uFE0F" + "Місто: " + location + "\n\n"
                + EmojiParser.parseToUnicode("\uD83D\uDCC5" + "Дата отримання квартири: " + data));

    }

}
