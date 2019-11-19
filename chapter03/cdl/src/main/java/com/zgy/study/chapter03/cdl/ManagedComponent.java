package com.zgy.study.chapter03.cdl;

/**
 * @author ZGY <br>
 * @date 2019/11/19 15:29 <br>
 * @description ManagedComponent <br>
 */
public interface ManagedComponent {
    /**
     * 查找
     * @param container
     */
    void performLookup(Container container);
}
