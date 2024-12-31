import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        try {
            // Заданий текст
            String inputText = "oruh hrhfyuuj rhrnng? ythnnbb gkdjhb ikkk fhhyhff ff tnjjnh. fjffnbdbddg lll tufjff ruik! ghjddnnh rrri rklfm rj?";

            // Задана довжина слова
            int wordLength = 4;

            // Виклик методу для обробки тексту
            processText(inputText, wordLength);
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }

    public static void processText(String text, int length) {
        // Перевірка вхідних даних
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім або null.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина слова повинна бути додатною.");
        }

        // Використання StringBuilder для обробки тексту
        StringBuilder stringBuilder = new StringBuilder(text.trim()); // Видалення зайвих пробілів на початку та в кінці

        // Розділення тексту на речення за допомогою регулярного виразу, зберігаючи розділові знаки
        String[] sentences = stringBuilder.toString().split("(?<=[.!?])");
        Set<String> uniqueWords = new HashSet<>(); // Унікальні слова

        for (String sentence : sentences) {
            sentence = sentence.trim(); // Видалення зайвих пробілів навколо речення

            // Перевірка, чи є речення питальним
            if (sentence.endsWith("?")) {
                // Розділення речення на слова
                String[] words = sentence.split("\\s+");
                for (String word : words) {
                    // Очищення слова від знаків пунктуації
                    word = word.replaceAll("[^\\p{L}]", ""); // Лише букви
                    if (word.length() == length) {
                        uniqueWords.add(word.toLowerCase()); // Додаємо слово в нижньому регістрі для уникнення повторів
                    }
                }
            }
        }

        // Вивід унікальних слів
        System.out.println("Унікальні слова довжини " + length + ": " + uniqueWords);
    }
}
