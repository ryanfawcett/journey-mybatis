package org.example.mybatis.util;

import java.util.Random;

@SuppressWarnings("unused")
public class RandomUtil {

    public static final int UPPERCASE_START = 65;
    public static final int UPPERCASE_END = 90;

    public static final int LOWERCASE_START = 97;
    public static final int LOWERCASE_END = 122;

    private static final Random random = new Random();

    private RandomUtil() {
    }

    public static int random(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }

    public static char randomUpperCase() {
        return (char) random(65, 90);
    }

    public static char randomLowerCase() {
        return (char) random(97, 122);
    }

    public static String randomString(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = random.nextBoolean() ? randomUpperCase() : randomLowerCase();
        }
        return new String(chars);
    }

    public static String randomIntsAsString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
