package jdk8newfeature.functionalinterfaceandlambda;

public class LambdaClass {

    public static String sayMessage(LambdaInterface i, String message) {
        return i.sayMessage(message);
    }

    public static void main(String[] args) {
        String msg = sayMessage(i -> "Hello" + i, " Functional Interface");
        System.out.println(msg);
    }
}
