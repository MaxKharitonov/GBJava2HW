package Java2HW.lesson3;

import java.util.ArrayList;

public class PhoneBook {
    private String name;
    private Integer phone_number;

    private final ArrayList<PhoneBook> phonebook = new ArrayList<>();

    public PhoneBook(){
    }
    public PhoneBook(String name, Integer phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public void add(String name, Integer phone_number){
        phonebook.add(new PhoneBook(name, phone_number));
    }

    public ArrayList<Integer> get(String name){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (PhoneBook pb: phonebook) {
            if (pb.getName().equalsIgnoreCase(name)) {
                numbers.add(pb.getPhone_number());
            }
        }
        return numbers;
    }

    public String getName() {
        return name;
    }

    public Integer getPhone_number() {
        return phone_number;
    }
}
