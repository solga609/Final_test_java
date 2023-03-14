package ToysShop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToysShop toysShop = new ToysShop();
        toysShop.addToyModel(new ToyModel(1, "Птичка", 3, 25));
        toysShop.addToyModel(new ToyModel(2, "Кукла", 8, 20));
        toysShop.addToyModel(new ToyModel(3, "Машинка", 12, 15));
        toysShop.addToyModel(new ToyModel(4, "Ракета", 6, 10));
        toysShop.addToyModel(new ToyModel(5, "Паровоз", 11, 30));
        toysShop.addToyModel(new ToyModel(6, "Кубики", 7, 15));
        toysShop.addToyModel(new ToyModel(7, "Самолет", 7, 25));
        toysShop.saveResult("toysShop.csv", toysShop);

        ToysShop toysPrize = new ToysShop();
        toysPrize.addToyModel(new ToyModel(3, "Машинка", 1, 15));
        toysPrize.addToyModel(new ToyModel(7, "Самолет", 1, 25));

        ToysShop toysIssued = new ToysShop();
        toysIssued.addToyModel(new ToyModel(6, "Кубики", 1, 15));
        toysShop.saveResult("toysIssued.csv", toysIssued);

        new Controller().onClick(toysShop, toysPrize, toysIssued);
    }
}
