package Workshop;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(13);
        stack.push(42);
        stack.push(73);
        stack.push(666);

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.forEach(System.out::println);
        System.out.println(stack.isEmpty());
    }
}
