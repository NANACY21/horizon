package com.personal.sta.proxy;

/**
 * 代理接口
 * 目标类和代理类要实现相同的接口，即代理接口
 */
public interface Subject {
    public void save();
    public void delete();
}
