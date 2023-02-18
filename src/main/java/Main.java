import Models.Category;
import Models.Manufacturer;
import Models.Product;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import org.json.JSONObject;

public class Main {
    static Scanner console = new Scanner(System.in);
    static ArrayList<Product> _products = new ArrayList<Product>();
    static ArrayList<Category> _categories = new ArrayList<Category>();
    static ArrayList<Manufacturer> _manufacturers = new ArrayList<Manufacturer>();
    public static void main(String[] args) {
        generateProducts();
        menu();
    }

    public static void menu(){
        int menuChoice;
        while (true){
            try{
                System.out.print("""
                         Menu
                        |===========================================================================|
                        | 1 = Show all Products\t\t\t\t\t\t\t\t\t\t\t\t\t\t|
                        | 2 = Show All Categories\t\t\t\t\t\t\t\t\t\t\t\t\t|
                        | 3 = Show by 1 manufacturer\t\t\t\t\t\t\t\t\t\t\t\t|
                        | 4 = show all under 100$\t\t\t\t\t\t\t\t\t\t\t\t\t|
                        | 5 = Show below the average price among all categories\t\t\t\t\t\t|
                        | 6 = Show below the average price among the most NOT popular categories    |
                        | 7 = Show least popular manufacturer in the most popular category\t\t\t|
                        | 8 = Show weighing up to 1kg (random only)\t\t\t\t\t\t\t\t\t|
                        | 9 = price from $1 to $5 and weighing up to 500 grams\t\t\t\t\t\t|
                        | 0 = Exit:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|
                        |===========================================================================|
                        """);
                menuChoice = console.nextInt();

                switch (menuChoice){
                    case 1:
                        System.out.println("All Products");
                        showAllProducts();
                        break;
                    case 2:
                        System.out.println("All Categories");
                        showAllCategories();
                        break;
                    case 3:
                        _manufacturers.forEach(m->System.out.println(m.getId() + " - " + m.getName()));
                        System.out.println("select number manufacturer:");
                        menuChoice = console.nextInt();
                        showByOneManufacturer(menuChoice).forEach(product -> System.out.println(product.toString()));
                        break;
                    case 4:
                        System.out.println("Products below 100$");
                        showBelow100().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 0: {return;}
                    default : System.out.println("\n\tInvalid Input !");
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

    public static void showAllProducts(){
        for (Product item: _products) {
            System.out.println(item.toString());
        }
    }
    public static void showAllCategories(){
        for (Category item: _categories) {
            System.out.println(item.toString());
        }
    }
    public static List<Product> showByOneManufacturer(int id){
        return  _products.stream().filter(p->p.getManufacturer().getId() == id).toList();
    }
    public static List<Product> showBelow100(){
        return _products.stream().filter(p->p.getPrice() < 100).toList();
    }
    public static Category selectCategory(int id){
        return _categories.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
    }
    public static Manufacturer selectManufacturer(int id){
        return _manufacturers.stream().filter(manufacturer -> manufacturer.getId() == id).findFirst().orElse(null);
    }
    public static Double roundDouble(double value){
        value = Math.round(value * 100);
        value = value / 100;
        return value;
    }
    public static void generateProducts(){
        _categories.add(new Category(0, "Fruit"));
        _categories.add(new Category(1, "Vegetable"));
        _categories.add(new Category(2, "Nut"));

        _manufacturers.add(new Manufacturer(0,"Ukraine"));
        _manufacturers.add(new Manufacturer(1, "Spain"));
        _manufacturers.add(new Manufacturer(2, "France"));

        Random random = new Random();

        _products.add(new Product(0, "Apple", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(0), selectManufacturer(0), random.nextInt(1000)));
        _products.add(new Product(1, "Pineapple", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(0), selectManufacturer(2), random.nextInt(1000)));
        _products.add(new Product(2, "Strawberry", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(0), selectManufacturer(1), random.nextInt(1000)));
        _products.add(new Product(3, "Chery", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(0), selectManufacturer(2), random.nextInt(1000)));
        _products.add(new Product(4, "Plum", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(0), selectManufacturer(0), random.nextInt(1000)));
        _products.add(new Product(5, "Potato", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(1), selectManufacturer(1), random.nextInt(1000)));
        _products.add(new Product(6, "Carrot", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(1), selectManufacturer(1), random.nextInt(1000)));
        _products.add(new Product(7, "Tomato", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(1), selectManufacturer(2), random.nextInt(1000)));
        _products.add(new Product(8, "Cucumber", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(1), selectManufacturer(0), random.nextInt(1000)));
        _products.add(new Product(9, "Pumpkin", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(1), selectManufacturer(0), random.nextInt(1000)));
        _products.add(new Product(10, "Peanut", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(2), selectManufacturer(0), random.nextInt(1000)));
        _products.add(new Product(11, "Cashew", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(2), selectManufacturer(2), random.nextInt(1000)));
        _products.add(new Product(12, "Almond", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(2), selectManufacturer(1), random.nextInt(1000)));
        _products.add(new Product(13, "Coconut", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(2), selectManufacturer(2), random.nextInt(1000)));
        _products.add(new Product(14, "Hazel", roundDouble(random.nextDouble(1200)), roundDouble(random.nextDouble(200)), selectCategory(2), selectManufacturer(0), random.nextInt(1000)));
    }
}