package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException  {
        // алфавит символов для пароля
        String password_symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=№;:?.,/1234567890";
        char ch;    // Для хранения текущего символа
        float frequencies[] = new float[password_symbols.length()];      // Для хранения частоты каждой буквы
        int counts[] = new int[password_symbols.length()];    // Для хранения количеств каждой буквы
        int flag = 0;    // Флаг
        String txt;
        Scanner scanner = new Scanner(System.in); // для ввода с клавиатуры
        System.out.println("[1] - ввод пароля набором \n" + "[2] - из файла");
        int choose = scanner.nextInt();
        if(choose == 1) {
            txt = scanner.next();              // вводим пароль с клавиатуры
        }
        else{
            System.out.println("Введите имя файла (src/test.txt)");
            String filename = "";
            filename += scanner.next();
            Path path = Paths.get(filename); // получаем путь для файла
            txt = Files.readString(path); // записываем текст из файла в строку
        }
        for(int i = 0; i < txt.length(); i++){     // перебираем строку
            // получаем текущий символ
            ch = txt.charAt(i);
            flag = 0;
            // Перебираем строку с алфавитом
            for(int j = 0; j < password_symbols.length(); j++){
                // проверяем, есть ли теккущий символ среди алфавита в переменной password_symbols//
                if(ch == password_symbols.charAt(j)) {
                    // если есть, то прибавляем к его позиции 1
                    counts[j]++;
                    break;
                }
            }
        }
        for(int i = 0; i < password_symbols.length(); i++) {
            // считаем частоту каждого симвлоа
            frequencies[i] = (float)counts[i]/txt.length();
        }
        float Ent = 0;
        // считаем энтропию по формуле Шеннона
        for(int i = 0; i < password_symbols.length(); i++){
            // !=0 т.к если определенного символа нет в пароле, то его частота равна 0
            if(frequencies[i] != 0) {
                // в Джаве нет встроенного двоичного логарифма, эта штука в скобках его заменяет
                Ent -= frequencies[i]*(Math.log(frequencies[i]) / Math.log(2));

            }
        }
        System.out.println("Энтропия равна:" + Ent +  password_symbols.length());
    }
}

