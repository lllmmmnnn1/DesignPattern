package com.design.sigleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr7 {

    private Mgr7() {

    }

    private static class Mgr7Hoder {
        private final static Mgr7 INSTANCE = new Mgr7();
    }

    public static Mgr7 getInstance() {
        return Mgr7Hoder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr7.getInstance().hashCode());
            }).start();
        }
    }

}
