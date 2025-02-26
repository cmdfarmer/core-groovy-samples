package com.example.scripts.compiler

import org.apache.commons.jci.compilers.CompilationResult
import org.apache.commons.jci.compilers.JavaCompiler
import org.apache.commons.jci.compilers.JavaCompilerFactory
import org.apache.commons.jci.readers.FileResourceReader
import org.apache.commons.jci.stores.FileResourceStore

import java.nio.file.Paths

def getCurrentPath() {
    return Paths.get("").toAbsolutePath().toString();
}


private void printCurrentDir() {
    println "Current path is ${getCurrentPath()}"
}

printCurrentDir()

// TODO: fix 
def sourceDirectory = Paths.get(getCurrentPath(), "javaclasses").toAbsolutePath().toString()
println "Source dir: $sourceDirectory"
JavaCompiler compiler = new JavaCompilerFactory().createCompiler("eclipse")
String[] resourcePaths = {"PlainObject.java"}
CompilationResult compilationResult = compiler.compile(resourcePaths,
        new FileResourceReader(new File(sourceDirectory)),
        new FileResourceStore(new File(sourceDirectory)));

def errors = compilationResult.getErrors()
println errors.length + " errors"


if (errors.length > 0) {
    def iterator = errors.iterator()

    while (iterator.hasNext()) {
        def problem = iterator.next()
        println problem
    }
}

println compilationResult.getWarnings().length + " warnings"