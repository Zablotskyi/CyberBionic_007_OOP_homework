public class Price {
    private String name;
    private String store;
    private int price;

    public Price() {
    }

    public Price(String name, String store, int price) {
        this.name = name;
        this.store = store;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", price=" + price +
                '}';
    }
}
