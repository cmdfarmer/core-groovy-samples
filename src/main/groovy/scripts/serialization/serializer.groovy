package com.example.scripts.serialization

class BinSerializer {
    void write(Object object, OutputStream stream) {
        stream.withObjectOutputStream { it -> it.writeObject(object) }
    }

    def read(InputStream stream) {
        return stream.withObjectInputStream { it -> return it.readObject(); }
    }
}