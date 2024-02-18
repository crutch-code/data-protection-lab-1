package ru.crutchcode.encryptor;

import ru.crutchcode.AlphabetUtil;

public class GammingEncrypt implements Encrypt {



    @Override
    public String encode(String phrase, String target) {
        StringBuilder builder = new StringBuilder();
        int it = 0;
        for (int i =0; i< target.length(); i++){
            if(target.charAt(i) == ' '){ builder.append(' '); continue; }
            builder.append(
                    AlphabetUtil.charAt(
                            (AlphabetUtil.posChar(phrase.charAt(it)) + AlphabetUtil.posChar(target.charAt(i))) % AlphabetUtil.ALPHABET_SIZE
                    )
            );
            if (++it >= phrase.length()){
                it = 0;
            }
        }
        return builder.toString();
    }

    public String sequence(){
        StringBuilder builder = new StringBuilder();
        int module = (int) (Math.round(Math.random() * 100) %AlphabetUtil.ALPHABET_SIZE);
        int length = 128;

        for(int i = 0 ; i < length; i++){
            int start = ((int) (Math.round(Math.random() * 100) %AlphabetUtil.ALPHABET_SIZE));
            int multiplier = (int) (Math.round(Math.random() * 1000) %AlphabetUtil.ALPHABET_SIZE);
            int increment = (int) (Math.round(Math.random() * 100) %AlphabetUtil.ALPHABET_SIZE);
            builder.append(
                    AlphabetUtil.charAt(
                            (start * multiplier + increment) % module
                    )
            );
        }
        return builder.toString();
    }
}
