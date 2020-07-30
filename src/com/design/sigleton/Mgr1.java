package com.design.sigleton;

/**
 * 饿汉式
 * 类加载到内存之后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点，不管使用与否，类加载时就完成实例化
 */
public class Mgr1 {
    private static final Mgr1 INSTANCE = new Mgr1();

    private Mgr1() {
    }

    public static Mgr1 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr1 m1 = Mgr1.getInstance();
        Mgr1 m2 = Mgr1.getInstance();
        System.out.println(m1 == m2);
    }
}
