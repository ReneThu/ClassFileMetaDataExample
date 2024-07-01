package com.agent;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyMethodVisitorTwo extends MethodVisitor {
    public MyMethodVisitorTwo(MethodVisitor methodVisitor, String className, String methodName, String methodToVisit) {
        super(Opcodes.ASM4, methodVisitor);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitLineNumber(int line, Label label) {
        switch (line) {
            case 12:
                super.visitLineNumber(7, label);
                break;
            case 11:
                super.visitLineNumber(8, label);
                break;
            case 10:
                super.visitLineNumber(9, label);
                break;
            case 9:
                super.visitLineNumber(10, label);
                break;
            case 8:
                super.visitLineNumber(11, label);
                break;
            case 6:
                super.visitLineNumber(6, label);
                break;
        }
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    @Override
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        super.visitLocalVariable(name, descriptor, signature, start, end, index);
    }
}
