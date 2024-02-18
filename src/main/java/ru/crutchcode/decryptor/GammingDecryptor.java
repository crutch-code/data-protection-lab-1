package ru.crutchcode.decryptor;

import ru.crutchcode.AlphabetUtil;

public class GammingDecryptor implements Decrypt{
    @Override
    public String decrypt(String phrase, String target) {
        StringBuilder builder = new StringBuilder();
        int it = 0;
        for (int i =0; i< target.length(); i++){
            if(target.charAt(i) == ' '){ builder.append(' '); continue; }

            int dim =  AlphabetUtil.posChar(target.charAt(i)) - AlphabetUtil.posChar(phrase.charAt(it));
            builder.append(
                    AlphabetUtil.charAt(
                            dim < 0 ? (dim + AlphabetUtil.ALPHABET_SIZE) % AlphabetUtil.ALPHABET_SIZE :
                                    dim % AlphabetUtil.ALPHABET_SIZE
                    )
            );
            if (++it >= phrase.length()) it =0;

        }
        return builder.toString();
    }
}
