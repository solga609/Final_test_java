package ToysShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ToysShop implements Iterable<ToyModel> {
    private List<ToyModel> toysShop;

    public ToysShop() {
        this.toysShop = new ArrayList<>();
    }

    // метод нахождения максимального id игрушки, для присвоения id новой игрушке
    private Integer lastid(ToysShop toysShop) {
        Integer lastid = 0;
        for (ToyModel t : toysShop) {
            if (t.getId() > lastid)
                lastid = t.getId();
        }
        return lastid;
    }

    public boolean equalsName(ToysShop toysShop, String name) {
        boolean flag = false;
        for (ToyModel t : toysShop) {
            if (t.getName().equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean equalsId(ToysShop toysShop, Integer id) {
        boolean flag = false;
        for (ToyModel t : toysShop) {
            if (t.getId() == id) {
                flag = true;
            }
        }
        return flag;
    }

    public void removeToy(ToysShop toysShop, int id) {
        for (int i = 0; i < toysShop.Size(); i++) {
            if (getToyModel(i).getId() == id) {
                this.toysShop.remove(id - 1);
            }
        }
    }

    // метод добавления игрушки в магазин, если модель есть в магазине - меняем
    // количество, если нет - добавляем новую
    public void addToy(ToysShop toysShop, String name_add, int count_add) {
        if (toysShop.equalsName(toysShop, name_add) == true) {
            for (ToyModel t : toysShop) {
                if (t.getName().equals(name_add)) {
                    changeToyAdd(t, count_add);
                }
            }
        } else {
            int id = lastid(toysShop) + 1;
            int weight = 0;
            ToyModel add = new ToyModel(id, name_add, count_add, weight);
            this.toysShop.add(add);
        }
    }

    public void addToyModel(ToyModel toyModel) {
        toysShop.add(toyModel);
    }

    // метод розыгрыша призовой игрушки
    public ToyModel raffleToy(ToysShop toysShop){
        Random rnd = new Random();
        int prizeId = rnd.nextInt(1, lastid(toysShop));
        String name = null;
        int count = 1;
        int weight = 0;
        for (ToyModel t : toysShop) {
            if (t.getId() == prizeId) {
                if (t.getCount() > 0) {
                    name = t.getName();
                    weight = t.getWeight();
                    changeToyPrize(toysShop, t);
                } else return null;                
            }
        }
        ToyModel prizeToy = new ToyModel(prizeId, name, count, weight);
        return prizeToy;
    }

    // метод внесения в список полученных и удаления из списка выигранных игрушек
    public void receiveToy(ToysShop toysShop) {
        toysShop.addToyModel(this.toysShop.remove(0));
    }

    // метод изменения количества и частоты призовых совпадений после розыгрыша
    public void changeToyPrize(ToysShop toysShop, ToyModel prize) {
        int l = (1 * 100 / lastid(toysShop));
        prize.setCount(prize.getCount() - 1);
        prize.setWeight(prize.getWeight() + l);
    }

    // метод изменения количества игрушек после добавления в магазин
    public void changeToyAdd(ToyModel prize, int count_add) {
        prize.setCount(prize.getCount() + count_add);
    }

    public void saveResult(String path, ToysShop toysShop) {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (ToyModel t : toysShop) {
                writer.append(String.format("id: %s  ", t.getId()))
                        .append(String.format("name: %s  ", t.getName()))
                        .append(String.format("count: %s  ", t.getCount()))
                        .append(String.format("weight: %s  ", t.getWeight()))
                        .append("\n");
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadToysShop(String path) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Магазин с игрушками: \n" + this.toysShop;
    }

    @Override
    public Iterator<ToyModel> iterator() {
        return toysShop.iterator();
    }

    public int Size() {
        return toysShop.size();
    }

    public ToyModel getToyModel(int argIndex) {
        return toysShop.get(argIndex);
    }
}