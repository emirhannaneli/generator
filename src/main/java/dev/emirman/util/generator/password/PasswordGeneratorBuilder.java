package dev.emirman.util.generator.password;

public final class PasswordGeneratorBuilder {
    private int length;
    private boolean useSpecialChars;
    private boolean useUpperCase;
    private boolean useNumbers;

    PasswordGeneratorBuilder() {
        this.length = 8;
        this.useSpecialChars = false;
        this.useUpperCase = false;
        this.useNumbers = false;
    }

    public static PasswordGeneratorBuilder newBuilder() {
        return new PasswordGeneratorBuilder();
    }

    public PasswordGeneratorBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public PasswordGeneratorBuilder useSpecialChars(boolean useSpecialChars) {
        this.useSpecialChars = useSpecialChars;
        return this;
    }

    public PasswordGeneratorBuilder useUpperCase(boolean useUpperCase) {
        this.useUpperCase = useUpperCase;
        return this;
    }

    public PasswordGeneratorBuilder useNumbers(boolean useNumbers) {
        this.useNumbers = useNumbers;
        return this;
    }

    public String build() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.withLength(length);
        passwordGenerator.useSpecialChars(useSpecialChars);
        passwordGenerator.useUpperCase(useUpperCase);
        passwordGenerator.useNumbers(useNumbers);
        return passwordGenerator.generate();
    }
}
