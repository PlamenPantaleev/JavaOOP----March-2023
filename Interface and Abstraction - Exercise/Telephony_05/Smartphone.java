package InterfaceAndAbstraction_04.Telephony_05;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    //-	numbers: List<String>
    //-	urls: List<String>
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (hasDigits(url)) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            if (!onlyDigits(number)) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private boolean hasDigits(String url) {
        char[] symbols = url.toCharArray();

        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean onlyDigits(String number) {
        char[] symbols = number.toCharArray();

        for (char symbol : symbols) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
}
