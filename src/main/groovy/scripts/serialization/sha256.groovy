package com.example.scripts.serialization


import org.apache.commons.codec.digest.DigestUtils

class Sha256Hash {
    static def calc(String text) {
        return DigestUtils.sha256Hex(text)
    }
}