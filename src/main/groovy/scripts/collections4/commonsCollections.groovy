package com.example.scripts.collections4

import org.apache.commons.collections4.IterableMap
import org.apache.commons.collections4.map.HashedMap

IterableMap<Integer, String> map = new HashedMap<>()
for (index in 0..<5) {
    map.put(index, "GENOMICS")
}

def iterator = map.mapIterator()
while (iterator.hasNext()) {
    def key = iterator.next()
    def value = iterator.value
    println "Key: $key, Value: $value"
}