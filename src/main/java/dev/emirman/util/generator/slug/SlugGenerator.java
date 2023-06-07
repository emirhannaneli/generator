package dev.emirman.util.generator.slug;

import dev.emirman.util.generator.password.PasswordGenerator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.util.Locale.ENGLISH;

public class SlugGenerator {
    private int length;

    public int length() {
        return length;
    }

    public SlugGenerator withLength(int length) {
        this.length = length;
        return this;
    }

    public String generate(String title) {
        String code = PasswordGenerator.builder()
                .useSpecialChars(false)
                .useNumbers(true)
                .useUpperCase(false)
                .withLength(length)
                .build();
        return URLEncoder.encode(title
                .replaceAll("\\s+", "-")
                .toLowerCase(ENGLISH)
                .replaceAll("[^a-zA-Z0-9\\-_]", "")
                .concat("-")
                .concat(code), StandardCharsets.UTF_8);
    }
}
