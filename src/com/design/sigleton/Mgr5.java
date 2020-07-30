package com.design.sigleton;

/**
 * 为了保证线程安全，加锁即可，但是效率会下降很多
 */
public class Mgr5 {
    private static Mgr5 INSTANCE;

    private Mgr5() {
    }

    public static Mgr5 getInstance() {
        if (INSTANCE == null) {
            //希望通过减少同步代码块的方式提高效率，然而不可行
            //在判断if的时候，在这个位置。可能有多个线程进来判断INSTANCE此时是为null的
            //但是最后可能在synchronized中new出多个对象
            synchronized (Mgr5.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr5();
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
                System.out.println(Mgr5.getInstance().hashCode());
            }).start();
        }
    }

}
