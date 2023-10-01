package org.seminar2;

import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static float enterFloat(){
        Scanner scan = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter float number: ");
                return Float.parseFloat(scan.nextLine());
        }
            catch (NumberFormatException ignored) {
            }
        }
    }
}
