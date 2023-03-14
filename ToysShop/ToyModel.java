package ToysShop;

public class ToyModel {
    private Integer id;
    private String name;
    private Integer count;
    private Integer weight;

    public ToyModel(Integer id, String name, Integer count, Integer weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        ToyModel t = (ToyModel) obj;
        return this.id == t.id && this.name == t.name;
    }

    @Override
    public String toString() {
        return "id игрушки: " + this.id + ", название игрушки: " + this.name + ", количество игрушек: " + this.count
                + ", частота призовых совпадений: " + this.weight;
    }
}