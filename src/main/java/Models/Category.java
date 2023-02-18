package Models;

public class Category{
    protected int _id;
    protected String _name;

    public Category(int id, String name){
        this._id = id;
        this._name = name;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    @Override
    public String toString(){
        return "{'name':" + _name +"}";
    }
}
