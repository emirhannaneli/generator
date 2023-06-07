package dev.emirman.util.generator.code;

public class CodeGenerator {
    private int length;

    public CodeGenerator(int length) {
        this.length = length;
    }

    public CodeGenerator() {
        this.length = 6;
    }

    public int length() {
        return length;
    }

    public CodeGenerator withLength(int length) {
        this.length = length;
        return this;
    }


    public CodeGeneratorBuilder builder() {
        return CodeGeneratorBuilder.newBuilder();
    }

    public Integer generate() {
        return (int) (Math.random() * Math.pow(10, length));
    }
}
