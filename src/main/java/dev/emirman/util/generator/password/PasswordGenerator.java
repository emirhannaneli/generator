package dev.emirman.util.generator.password;

import java.security.SecureRandom;

public class PasswordGenerator {
    private int length;
    private boolean useSpecialChars;
    private boolean useUpperCase;
    private boolean useNumbers;

    public PasswordGenerator() {
        this.length = 8;
        this.useSpecialChars = false;
        this.useUpperCase = false;
        this.useNumbers = false;
    }

    public static PasswordGeneratorBuilder builder() {
        return new PasswordGeneratorBuilder();
    }

    public PasswordGenerator withLength(int length) {
        this.length = length;
        return this;
    }

    public PasswordGenerator useSpecialChars(boolean useSpecialChars) {
        this.useSpecialChars = useSpecialChars;
        return this;
    }

    public PasswordGenerator useUpperCase(boolean useUpperCase) {
        this.useUpperCase = useUpperCase;
        return this;
    }

    public PasswordGenerator useNumbers(boolean useNumbers) {
        this.useNumbers = useNumbers;
        return this;
    }

    public String generate() {
        StringBuilder password = new StringBuilder();
        String possibleChars = "abcdefghijklmnopqrstuvwxyz";
        if (useUpperCase) {
            possibleChars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (useNumbers) {
            possibleChars += "0123456789";
        }
        if (useSpecialChars) {
            possibleChars += "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        }

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(possibleChars.length());
            password.append(possibleChars.charAt(index));
        }

        return password.toString();
    }
}
