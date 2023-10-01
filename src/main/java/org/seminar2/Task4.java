package org.seminar2;

import java.util.Scanner;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void enterString() throws NullPointerException {
        Scanner scan = new Scanner(System.in);
        String s;
        while (true){
            try {
                System.out.println("Enter some string: ");
                s = scan.nextLine();
                if (s.isEmpty()){
                    throw new NullPointerException("Empty line is not allowed: ");
                }
                return;
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
