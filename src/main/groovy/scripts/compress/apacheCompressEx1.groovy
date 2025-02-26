package com.example.scripts.compress


import org.apache.commons.compress.compressors.CompressorOutputStream
import org.apache.commons.compress.compressors.CompressorStreamFactory

def printBytes(def str) {
    bytes = str as byte[]
    println "Bytes: ${bytes.toString()}"
}

private String testCompressor() {

    ByteArrayOutputStream stream = new ByteArrayOutputStream()
    CompressorOutputStream compressedStream = new CompressorStreamFactory()
            .createCompressorOutputStream(CompressorStreamFactory.GZIP, stream)

    def text = "MY TEST MESSAGE WITH COMPRESSION"
    printBytes(text)

    compressedStream.write(text.getBytes("UTF-8"))
    def compressedText = new String(stream.toString())
    printBytes(compressedText)
    compressedText
}

String compressedText = testCompressor()



// TODO: fix
def streamToDecompress = new ByteArrayInputStream(compressedText.getBytes("UTF-8"))
def decompressor = new CompressorStreamFactory()
        .createCompressorInputStream(CompressorStreamFactory.GZIP, streamToDecompress)


println "Decompressed ${decompressor.toString()}"

