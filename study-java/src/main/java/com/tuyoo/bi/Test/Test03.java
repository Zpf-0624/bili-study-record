package com.tuyoo.bi.Test;

/**
 * @Author zhangpengfei
 * @Date 2023-09-02 20:46
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
class Parent {
    String attribute = "Parent attribute";
    String ap = "1";
    public void print(){
        System.out.println("parent");
    }
    public void p(){
        System.out.println("p");
    }
}

class Child extends Parent {
    String attribute = "Child attribute";
    String ac = "2";
    public void print(){
        System.out.println("Child");
    }
    public void c(){
        System.out.println("c");
    }
}

public class Test03 {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.attribute); // 输出 "Parent attribute"，访问的是父类的属性
        System.out.println(parent.ap);
        Child a = (Child) parent;
        parent.p();
        parent.print();
        System.out.println(a.ac);

        System.out.println("======");

        Child child = new Child();
        System.out.println(child.attribute); // 输出 "Child attribute"，访问的是子类的属性
        child.p();
        child.print();
        child.c();
    }
}