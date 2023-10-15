public class IceCream {
    String icId;
    String Name;
    String type;
    double price;

    public IceCream(String icId, String name, String type, double price) {
        this.icId = icId;
        this.Name = name;
        this.type = type;
        this.price = price;
    }

    public String getIcId() {
        return icId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setIcId(String icId) {
        this.icId = icId;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name+ " " + type + " -- " + price + "$";
    }
}
