package ToysShop;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    /**
     * @param toysShop
     */
    public void printToys(ToysShop toysShop) {
        for (ToyModel toy : toysShop) {
            System.out.println(toy);
        }
    }

    public void printToy(ToyModel toy) {
        System.out.println(toy);
    }

    public void printStr(String s) {
        System.out.println(s);
    }

    public String scanString(String s) {
        System.out.println(s);
        scanner = new Scanner(System.in, "Cp866");
        return scanner.nextLine();
    }

    public Integer scanInt(String s) {
        System.out.println(s);
        scanner = new Scanner(System.in);
        String int_s = scanner.nextLine();
        try {
            Integer res = Integer.parseInt(int_s);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return Integer.parseInt(int_s);
    }
}