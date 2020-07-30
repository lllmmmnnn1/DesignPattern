package com.design.sigleton;

/**
 * 为了保证线程安全，加锁即可，但是效率会下降很多
 */
public class Mgr4 {
    private static Mgr4 INSTANCE;

    private Mgr4() {
    }

    public static synchronized Mgr4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr4();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr4.getInstance().hashCode());
            }).start();
        }
    }

}
