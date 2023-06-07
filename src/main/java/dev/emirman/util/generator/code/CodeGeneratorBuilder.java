package dev.emirman.util.generator.code;

public final class CodeGeneratorBuilder extends CodeGenerator {
    private int length = 6;

    private CodeGeneratorBuilder() {
    }

    public static CodeGeneratorBuilder newBuilder() {
        return new CodeGeneratorBuilder();
    }

    public CodeGeneratorBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public Integer build() {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.withLength(length);
        return generate();
    }
}
