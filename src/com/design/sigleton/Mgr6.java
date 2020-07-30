package com.design.sigleton;

/**
 * 双判断检查线程安全,这是安全的
 */
public class Mgr6 {
    //volatile禁止指令重排序
    private static volatile Mgr6 INSTANCE;

    private Mgr6() {

    }

    public static Mgr6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr6();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr6.getInstance().hashCode());
            }).start();
        }
    }

}
