package Java2HW.lesson3;

import java.util.HashMap;

public class lesson3 {
    public static void main(String[] args) {
        String[] wordsArray = {"What", "Java", "Contains", "?", "World", "Hello",
                "Java", "Contains", "Arrays", "Integers", "Strings", ".",
                "First", "Program", "Is", "Called", ": ", "Hello", "World", "."};
        HashMap<String, Integer> unique = new HashMap<>();
        for (String s : wordsArray) {
            unique.put(s, unique.getOrDefault(s, 0) + 1);
        }
        System.out.println(unique.keySet());
        System.out.println(unique);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Igor", 7825252);
        phoneBook.add("Sergei", 672235);
        phoneBook.add("Vladimir", 6728536);
        phoneBook.add("Vladimir", 7237895);

        String name = "Vladimir";
        System.out.println(name + " - " + phoneBook.get(name));
    }
}