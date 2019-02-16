package com.kfzx.concurrency;

/**
 * @author MR.Tian
 */
public class TemplateMethod {

    final void print(String message) {
        System.out.println("################");
        wrapPrint(message);
        System.out.println("################");
    }

    void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        t1.print("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };

        t2.print("Hello Thread");
    }
}
