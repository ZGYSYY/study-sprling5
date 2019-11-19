package com.zgy.study.chapter03.cdl;

/**
 * @author ZGY <br>
 * @date 2019/11/19 15:29 <br>
 * @description Container <br>
 */
public interface Container {
    /**
     * 获取依赖
     * @param key
     * @return
     */
    Object getDependency(String key);
}
