package ru.crutchcode.encryptor;

import ru.crutchcode.AlphabetUtil;

public class VigenerEncrypt implements Encrypt{
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


}
