package Models;

public class Product {
    protected int _id;
    protected String _name;
    protected  double _weight;
    protected  double _price;
    protected  Category _category;
    protected  Manufacturer _manufacturer;

    protected int _salesCount;

    public Product(int id, String name, double weight, double price, Category category, Manufacturer manufacturer, int salesCount){
        this._id = id;
        this._name = name;
        this._weight = weight;
        this._price = price;
        this._category = category;
        this._manufacturer = manufacturer;
        this._salesCount = salesCount;
    }

    public double getPrice() {
        return _price;
    }

    public Category getCategory() {
        return _category;
    }

    public Manufacturer getManufacturer() {
        return _manufacturer;
    }

    @Override
    public String toString(){
        return "{'id':" + _id +
                ", 'name':" + _name +
                ", 'price':" + _price +
                ", 'weight':" + _weight +
                ", 'category':" + _category +
                ", 'manufacturer':" + _manufacturer +
                ", 'sales':" + _salesCount + "}";
    }
}
