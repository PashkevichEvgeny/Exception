package org.seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        enterData();
    }
    public static void enterData(){
        Scanner scan = new Scanner(System.in);
        String[] s;
        String name;
        while (true){
            try {
                System.out.println("Введите ФИО дата рождения(дд.мм.гггг) номер телефона(79876543210) пол(m|f): ");
                s = scan.nextLine().split(" ");
                if (s.length < 6){
                    throw new LessDataException("Не все данные введены");
                }
                else if (s.length > 6){
                    throw new MoreDataException("Введено слишком много данных");
                }
                else {
                    String fullname = null;
                    String birthday = null;
                    String phonenumber = null;
                    String gender = null;
                    for (int i = 0; i < s.length - 2; i++) {
                        if ((s[i] + s[i + 1] + s[i + 2]).matches("[а-яА-Яё]+")) {
                            fullname = s[i] + " " + s[i + 1] + " " + s[i + 2];
                            break;
                        }
                    }
                    if (fullname == null) {
                        throw new OnlyLetterInNameException("ФИО должны содержать только кириллические символы");
                    }
                    for (String string : s) {
                        if (string.matches("\\d{2}[.]\\d{2}[.]\\d{4}")) birthday = string;
                        if (string.matches("\\d{10}")) phonenumber = string;
                        if (string.equals("m") | string.equals("f")) gender = string;
                    }
                    if (birthday == null) {
                        throw new WrongFormatDateException("Неверный формат даты(дд.мм.гггг)");
                    }
                    if (phonenumber == null) {
                        throw new WrongFormatPhoneNumberException("Неверный формат номера телефона(79876543210)");
                    }
                    if (gender == null) {
                        throw new WrongGenderException("Неверно указан пол(m|f)");
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(fullname).append(" ");
                    stringBuilder.append(birthday).append(" ");
                    stringBuilder.append(phonenumber).append(" ");
                    stringBuilder.append(gender);
                    writeFile(stringBuilder, (String) fullname.subSequence(0, fullname.indexOf(" ")));
                    return;
                }
            }
            catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(StringBuilder stringBuilder, String fileName) throws IOException {
//      Запись файла
        FileWriter fileWriter = new FileWriter(fileName+".txt", true);
        fileWriter.write(stringBuilder + "\n");
        fileWriter.flush();
        fileWriter.close();
    }

}

abstract class UserInputException extends RuntimeException{

    public UserInputException(String message){
        super(message);
    }
}

class LessDataException extends UserInputException{

    public LessDataException(String message) {
        super(message);
    }
}

class MoreDataException extends UserInputException{

    public MoreDataException(String message) {
        super(message);
    }
}

class OnlyLetterInNameException extends UserInputException{

    public OnlyLetterInNameException(String message) {
        super(message);
    }
}

class WrongFormatDateException extends UserInputException{
    public WrongFormatDateException(String message){
        super(message);
    }
}

class WrongFormatPhoneNumberException extends UserInputException{

    public WrongFormatPhoneNumberException(String message) {
        super(message);
    }
}

class WrongGenderException extends UserInputException{

    public WrongGenderException(String message) {
        super(message);
    }
}


// Иванов Петр Сидорович 01.01.2000 1234567890 m