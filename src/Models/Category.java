package Models;

public class Category{
    protected int _id;
    protected String _name;

    public Category(int id, String name){
        this._id = id;
        this._name = name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }
}
