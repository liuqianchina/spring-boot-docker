package jdk10newfeature;

public class LocalVariableInfer {

    public static void main(String[] args) {
        for (var i = 0; i < 10; i ++) {
            var a = 1;
            i += a;
        }
    }
}
