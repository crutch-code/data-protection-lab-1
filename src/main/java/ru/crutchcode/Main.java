package ru.crutchcode;

import ru.crutchcode.decryptor.Decrypt;
import ru.crutchcode.decryptor.GammingDecryptor;
import ru.crutchcode.decryptor.VigenerDecrypt;
import ru.crutchcode.encryptor.Encrypt;
import ru.crutchcode.encryptor.GammingEncrypt;
import ru.crutchcode.encryptor.VigenerEncrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        Encrypt encrypt;
        Decrypt decrypt;
        String file, phrase, target, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Choice: \n\t1.Gamming\n\t2.Vigener");
        int strategy = input.nextInt();
        switch (strategy) {
            case 1 -> {
                encrypt = new GammingEncrypt();
                decrypt = new GammingDecryptor();
            }
            case 2 -> {
                encrypt = new VigenerEncrypt();
                decrypt = new VigenerDecrypt();
            }
            default -> {
                throw new IllegalArgumentException("Invalid value");
            }
        }
        input.nextLine();
        System.out.println("Print the target text: \n");
        target = input.nextLine();
        System.out.println(target);
        System.out.println("Choice: \n1. Ecnrypt \n2. Decrypt");
        int type = Integer.parseInt(input.next());
        switch (type) {
            case 1 -> {
                if (strategy == 1) {
                    phrase = ((GammingEncrypt)encrypt).sequence();
                    System.out.println(phrase);
                }else {
                    System.out.println("Print code phrase: \n" );
                    phrase = input.next();
                    System.out.println(phrase);
                }
                print(phrase, "crypt_text.txt", encrypt.encode(phrase, target));
            }
            case 2 -> {
                System.out.println("Print code phrase: \n" );
                phrase = input.next();
                print(phrase, "decrypt_text.txt", decrypt.decrypt(phrase, target));
            }
            default -> throw new IllegalArgumentException("Invalid Value");
        }


    }

    public static void print(String phrase, String file, String target) throws IOException {
        FileWriter writer = new FileWriter(file, false);
        writer.write("Code phrase: " + phrase);
        writer.append('\n');
        writer.write(target);
        writer.flush();
    }

}