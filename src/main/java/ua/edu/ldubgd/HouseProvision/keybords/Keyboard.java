package ua.edu.ldubgd.HouseProvision.keybords;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {

        public static ReplyKeyboardMarkup chooseDocuments() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();


        row1.add("Компенсація за піднайом(найом)");
        row2.add("Компенсація за належне їм для Отримання  жиле приміщення");


        keyboardRows.add(row1);
        keyboardRows.add(row2);


        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;

    }

        public static ReplyKeyboardMarkup chooseCompensation() {
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setSelective(true);
                replyKeyboardMarkup.setResizeKeyboard(true);
                replyKeyboardMarkup.setOneTimeKeyboard(true);

                List<KeyboardRow> keyboardRows = new ArrayList<>();
                KeyboardRow row1 = new KeyboardRow();
                KeyboardRow row2 = new KeyboardRow();


                row1.add("Розрахунок компенсації за піднайом(найом)");
                row2.add("Розрахунок компенсації за належне їм для отримання  жиле приміщення");


                keyboardRows.add(row1);
                keyboardRows.add(row2);


                replyKeyboardMarkup.setKeyboard(keyboardRows);
                return replyKeyboardMarkup;

        }

}