package com.design.sigleton;

/**
 * 不仅可以解决线程同步，还可以防止序列化
 */
public enum Mgr8 {

    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr8.INSTANCE.hashCode());
            }).start();
        }
    }

}
