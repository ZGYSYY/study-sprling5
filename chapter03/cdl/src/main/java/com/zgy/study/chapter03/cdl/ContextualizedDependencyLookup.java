package com.zgy.study.chapter03.cdl;

/**
 * @author ZGY <br>
 * @date 2019/11/19 15:32 <br>
 * @description ContextualizedDependencyLookup <br>
 */
public class ContextualizedDependencyLookup implements ManagedComponent{
    private Dependency dependency;


    /**
     * 查找
     *
     * @param container
     */
    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
