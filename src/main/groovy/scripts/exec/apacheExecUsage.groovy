package com.example.scripts.exec

import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor
import org.apache.commons.exec.PumpStreamHandler

//def command = 'cmd /c chcp' // определить кодировку (866)
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