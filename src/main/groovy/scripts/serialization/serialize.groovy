package com.example.scripts.serialization

import groovy.transform.ToString

@ToString
class ObjectStructure implements Serializable {
    Integer id
    String name
    String checkSum
    String metadata

    ObjectStructure() {
        this.id = 1
        this.name = "Object52"
        this.checkSum = Sha256Hash.calc("UNKNOWN OBJECT 52")
        this.metadata = "[DATA DELETED]"
    }
}

def object = new ObjectStructure()

def writer = new BinSerializer()
writer.write(object, new FileOutputStream("struct.bin"))

def reader = new BinSerializer()
def targetObj = reader.read(new FileInputStream("struct.bin"))
println "Target object is ${targetObj}"