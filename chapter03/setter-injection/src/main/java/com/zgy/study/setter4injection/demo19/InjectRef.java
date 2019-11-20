package com.zgy.study.setter4injection.demo19;

/**
 * @author ZGY <br>
 * @date 2019/11/20 11:29 <br>
 * @description InjectRef <br>
 */
public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
