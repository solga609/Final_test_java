package ToysShop;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public void onClick(ToysShop toysShop, ToysShop toysPrize, ToysShop toysIssued) throws IOException {
        View view = new View();

        System.out.println("Добро пожаловать в магазин игрушек... " +
                "\nВыберите какое действие нужно выполнить:" +
                "\n1 - Просмотреть список всех игрушек в магазине" +
                "\n2 - Добавить игрушки в магазин" +
                "\n3 - Организовать розыгрыш игрушек" +
                "\n4 - Получить призовую игрушку" +
                "\n0 - Выход из программы" +
                "\n>>> ");

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String key = in.next();
                view.printStr("\033[H\033[J");
                switch (key) {
                    case "1":
                        view.printToys(toysShop);
                        break;
                    case "2":
                        String name = view.scanString("Введите наименование игрушки");
                        if (toysShop.equalsName(toysShop, name) == true) {
                            view.printStr("Такая игрушка есть в магазине");
                        }
                        Integer count = view.scanInt("Введите количество игрушек, которых хотите добавить");
                        toysShop.addToy(toysShop, name, count);
                        // view.printToys(toysShop); // для проверки
                        view.printStr("Игрушки добавлены в магазин");
                        break;
                    case "3":
                        view.printStr("Начинаем розыгрыш призовых игрушек. ");
                        ToyModel prizeToy = toysShop.raffleToy(toysShop);
                        if (prizeToy != null) {
                            view.printStr("Выиграла игрушка:");
                            view.printToy(prizeToy);
                            toysPrize.addToyModel(prizeToy);
                            view.printStr("Список выигранных игрушек, которые ожидают выдачи:");
                            view.printToys(toysPrize);
                        } else {
                            view.printStr(
                                    "К сожалению приз выпал на игрушку, которая закончилась в магазине. Розыгрыш закончен");
                        }
                        break;
                    case "4":
                        view.printStr("Список полученных игрушек:");
                        view.printToys(toysIssued);
                        view.printStr("Список выигранных игрушек, которые ожидают выдачи:");
                        view.printToys(toysPrize);
                        view.printStr("Получаем первую по списку игрушку.");
                        if (toysPrize.Size() > 0) {
                            toysPrize.receiveToy(toysIssued);
                            view.printStr("Список полученных игрушек после получения:");
                            view.printToys(toysIssued);
                            toysShop.saveResult("toysIssued.csv", toysIssued);
                            view.printStr(
                                    "Список выигранных игрушек, которые ожидают выдачи, после получения игрушки:");
                            view.printToys(toysPrize);
                        } else
                            view.printStr("В списке выигранных игрушек, которые ожидают выдачи - нет игрушек");
                        break;
                    default:
                        view.printStr("Выход из программы");
                        return;
                }
            }
        }
    }
}