package InterfacesAndAbstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            char[] chars = number.toCharArray();
            boolean isValid = true;
            for (char aChar : chars) {

                if (Character.isLetter(aChar)) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            char[] chars = url.toCharArray();
            boolean isValid = true;
            for (char aChar : chars) {

                if (Character.isDigit(aChar)) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
