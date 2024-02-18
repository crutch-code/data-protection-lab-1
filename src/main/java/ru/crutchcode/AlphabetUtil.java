package ru.crutchcode;

public class AlphabetUtil {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,.;!?-" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static final int ALPHABET_SIZE = alphabet.length();

    public static char charAt(int pos){
        return alphabet.charAt(pos);
    }

    public static int posChar(char c){
        return alphabet.indexOf(c);
    }


}
