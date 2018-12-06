package com;

public class DoubleCheck {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }

    static class Singleton {
        private volatile static Singleton singleton = new Singleton();

        public Singleton() {
        }

        public static Singleton getInstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return new Singleton();
        }
    }
}
