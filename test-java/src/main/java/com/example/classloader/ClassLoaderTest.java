package com.example.classloader;

/**
 * @author yulshi
 * @create 2020/06/06 23:10
 */
public class ClassLoaderTest {

  public static void main(String[] args) {

    System.out.println(Sub.value);

  }


  private static class Super {
    static {
      System.out.println("Super init");
    }

    static String value = "Hello Super";
  }

  private static class Sub extends Super {
    static {
      System.out.println("Sub init");
    }

//    static String value = "Hello Sub";
  }

}
