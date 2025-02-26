package com.example.scripts.pool

import org.apache.commons.pool2.BasePooledObjectFactory
import org.apache.commons.pool2.PooledObject
import org.apache.commons.pool2.impl.DefaultPooledObject
import org.apache.commons.pool2.impl.GenericObjectPool
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

GenericObjectPoolConfig config = new GenericObjectPoolConfig();
config.setMinIdle(2);
config.setMaxIdle(5);
config.setMaxTotal(20);

class StrPooledObjectFactory extends BasePooledObjectFactory<String> {

    private int index = 0;

    @Override
    String create() throws Exception {
        return "HELLO${index++}"
    }

    @Override
    PooledObject<String> wrap(String obj) {
        return new DefaultPooledObject<String>(obj)
    }
}

def factory = new StrPooledObjectFactory()
GenericObjectPool<String> pool = new GenericObjectPool<>(factory);
pool.addObject()
pool.addObject()

def object = pool.borrowObject()
println "Borrow: $object"

def object2 = pool.borrowObject()
println "Borrow: $object2"

//for (i in 0..10) {
//    println pool.borrowObject()
//}