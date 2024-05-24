import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private  static  final  int fieldsNumber = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        String input = scanner.nextLine();
        scanner.close();
        String[] fields = input.split(" ");
        if (fields.length != fieldsNumber) {
            System.err.println("Не верное количество полей, вы ввели " + fields.length + ", введите 6 полей");
        }
        String lastName = fields[0];
        String firstName = fields[1];
        String middleName = fields[2];
        LocalDate birthDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDate = LocalDate.parse(fields[3], formatter);
        }catch (DateTimeException e) {
            System.err.println("Не верный формат даты");
            return;
        }
        long poneNumber;
        try {
            poneNumber = Long.parseLong(fields[4]);
        }catch (NumberFormatException e){
            System.err.println("Не верный формат телефона");
            return;
        }
        String gender = fields[5];
        if ((!"m".equals(gender)) && (!"f".equals(gender))) {
            System.err.println("Не верный формат пола введите f или m");
            return;
        }
    String filename = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + poneNumber + " " + gender);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи!");;
        }
    }
}