package FinalExam7Aug;

import java.util.*;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> userMap = new LinkedHashMap<>();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Statistics")) {
            String command = commandLine.split("=")[0];
            String username = commandLine.split("=")[1];

            switch (command) {
                case "Add":
                    int sent = Integer.parseInt(commandLine.split("=")[2]);
                    int received = Integer.parseInt(commandLine.split("=")[3]);

                    userMap.putIfAbsent(username, new ArrayList<>());
                    userMap.get(username).add(sent);
                    userMap.get(username).add(received);
                    break;

                case "Message":
                    String sender = commandLine.split("=")[1];
                    String receiver = commandLine.split("=")[2];

                    if (userMap.containsKey(sender) && userMap.containsKey(receiver) && !sender.equals(receiver)) {
                        userMap.get(sender).set(0, userMap.get(sender).get(0) + 1);
                        userMap.get(receiver).set(1, userMap.get(receiver).get(1) + 1);

                        if (isUserReachedCapacity(userMap.get(sender), capacity)) {
                            System.out.printf("%s reached the capacity!%n", sender);
                            userMap.remove(sender);
                        }
                        if (isUserReachedCapacity(userMap.get(receiver), capacity)) {
                            System.out.printf("%s reached the capacity!%n", receiver);
                            userMap.remove(receiver);
                        }
                    }
                    break;

                case "Empty":
                    userMap.remove(username);
                    if (username.equals("All")){
                        userMap.clear();
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println("Users count: " + userMap.size());

        for (Map.Entry<String, List<Integer>> entry : userMap.entrySet()) {
            String userName = entry.getKey();
            int messageCount = entry.getValue().stream().mapToInt(Integer::intValue).sum();

            System.out.printf("%s - %d%n", userName, messageCount);
        }
    }

    private static boolean isUserReachedCapacity(List<Integer> userMessages, int capacity) {
        return userMessages.stream().mapToInt(Integer::intValue).sum() == capacity;
    }
}
