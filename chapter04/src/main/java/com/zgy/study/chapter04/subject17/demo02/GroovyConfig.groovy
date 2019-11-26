package com.zgy.study.chapter04.subject17.demo02

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def context = new GenericApplicationContext();
def reader = new GroovyBeanDefinitionReader(context);

reader.beans {
    singer(Singer, name: 'ZGY LHM', age: 23)
}

context.refresh()

println context.getBean("singer")
