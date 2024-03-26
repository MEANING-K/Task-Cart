package task_cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Product {
    private String key;
    private String name;
    private double price;

    public Product(String key, String name, double price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(key, product.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    // CSV 파일에서 상품을 읽어오는 메서드
    public static Set<Product> readProductsFromCSV(String filename) {
        Set<Product> products = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/task_cart/" + "products.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String key = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    products.add(new Product(key, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}