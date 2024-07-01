package com.agent;


import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

    public MyTransformer() {
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.contains("org/example/DebuggerExample")) {
            File file = new File("src/classFiles/DebuggerExample.class");
            try {
                //Replace classFile by modified one
                byte[] byteArray = FileUtils.readFileToByteArray(file);
                ClassReader classReader = new ClassReader(byteArray);

                final ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
                classReader.accept(new MyVisitor(classWriter, className, "main"), ClassReader.EXPAND_FRAMES);
                return classWriter.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
