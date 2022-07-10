package AssociativeArrays.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> usersMap = new LinkedHashMap<>();

        while (!input.equals("End")){
            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if (!usersMap.containsKey(companyName)){
                usersMap.put(companyName, new ArrayList<>());
                usersMap.get(companyName).add(employeeID);
            } else {
                if (!isEmployeeIDExist(usersMap, employeeID)) {
                    usersMap.get(companyName).add(employeeID);
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : usersMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String employee : entry.getValue()){
                System.out.printf("-- %s%n", employee);
            }
        }

    }

    private static boolean isEmployeeIDExist(Map<String, List<String>> usersMap, String employeeID) {
        for (Map.Entry<String, List<String>> entry : usersMap.entrySet()) {
            if (entry.getValue().contains(employeeID)){
                return true;
            }
        }
        return false;
    }
}
