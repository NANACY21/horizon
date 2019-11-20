package com.personal.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestCollection {
    private List<String> lst;
    private Map<String,String> maps;
    private Set<String> sets;
    private Properties props;

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void list() {
        for (String s : lst) {
            System.out.println(s);
        }
    }

    public void set() {
        for (String s : sets) {
            System.out.println(s);
        }
    }

    public void map() {
        Set<Map.Entry<String, String>> entries = maps.entrySet();

        for (Map.Entry<String,String> entry : entries) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public void prop() {
        Set<Map.Entry<Object, Object>> entries = props.entrySet();
        for (Map.Entry<Object,Object> entry : entries) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
