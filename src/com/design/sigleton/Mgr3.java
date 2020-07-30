package com.design.sigleton;

/**
 * 懒汉式，什么时候使用的时候，什么时候才初始化
 * 虽然达到了按需求初始化的目的，确带来了线程不安全的问题
 */
public class Mgr3 {

    private static Mgr3 INSTANCE;

    private Mgr3() {
    }

    public static Mgr3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //高并发的情况下，首先进来一个线程，实例还没有new的时候，INSTANCE为空
            //这时候if判断为null，依旧可以有新的进程进来，即可以new多次，不再是单例
            INSTANCE = new Mgr3();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr3.getInstance().hashCode());
            }).start();
        }
    }

}
