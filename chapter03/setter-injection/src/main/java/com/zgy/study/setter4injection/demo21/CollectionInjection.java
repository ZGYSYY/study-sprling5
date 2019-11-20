package com.zgy.study.setter4injection.demo21;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author ZGY <br>
 * @date 2019/11/20 13:30 <br>
 * @description CollectionInjection <br>
 */
public class CollectionInjection {

    private Map<String, Object> map;
    private Properties properties;
    private Set<Object> set;
    private List<Object> list;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<Object> getSet() {
        return set;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void displayInfo() {
        System.out.println("Map contents: \n");
        map.entrySet().stream().forEach(e -> System.out.println("Key: " + e.getKey() + "- Value: " + e.getValue()));

        System.out.println("\nProperties contents: \n");
        properties.entrySet().stream().forEach(e -> System.out.println("Key: " + e.getKey() + "- Value: " + e.getValue()));

        System.out.println("\nSet contents: \n");
        set.forEach(e -> System.out.println("Value: " + e));

        System.out.println("\nList contents: \n");
        list.forEach(e -> System.out.println("Value: " + e));
    }
}
