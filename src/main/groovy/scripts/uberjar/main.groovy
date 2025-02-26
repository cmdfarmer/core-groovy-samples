package com.example.scripts.uberjar

import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor
import org.apache.commons.exec.PumpStreamHandler


class Main {

    static def callPing() {
        def command = 'cmd /c ping google.com'
        def sysOutStream = new ByteArrayOutputStream()
        def sysErrStream = new ByteArrayOutputStream()

        CommandLine commandLine = CommandLine.parse(command)
        def executor = new DefaultExecutor()
        def streamHandler = new PumpStreamHandler(sysOutStream, sysErrStream)
        executor.setStreamHandler(streamHandler)

        int exitCode = executor.execute(commandLine)
        println "exit code: ${exitCode}"
        println "${sysOutStream.toString("IBM866")}"
    }

    static void main(String[] args) {
        println "Hello world!"
        callPing()
    }
}