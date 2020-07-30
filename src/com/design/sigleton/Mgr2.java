package com.design.sigleton;

/**
 * 和第一个没有本质的区别，基本一样
 */
public class Mgr2 {
    private static final Mgr2 INSTANCE;

    static {
        INSTANCE=new Mgr2();
    }

    private Mgr2(){}

    public static Mgr2 getInstance(){
        return INSTANCE;
    }

}
