package thread;

import org.assertj.core.util.Lists;

import java.util.List;

public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    public static final ThreadLocal<ThreadLocalTest> threadLocal = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void addMessage(String message) {
        threadLocal.get().messages.add(message);
    }

    public static List<String> clearAllMessage() {
        final List<String> messages = threadLocal.get().messages;
        threadLocal.remove();
        System.out.println("The size of messages: " + threadLocal.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.addMessage("Hello Thread Local Message 1");
        System.out.println(threadLocal.get().messages);
        System.out.println(ThreadLocalTest.class.getClassLoader());
        System.out.println(ThreadLocalTest.class.getClassLoader().getParent());
        System.out.println(ThreadLocalTest.class.getClassLoader().getParent().getParent());
    }
}
