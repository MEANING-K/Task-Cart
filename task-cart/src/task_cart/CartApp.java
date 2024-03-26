package task_cart;

import java.util.*;

public class CartApp {
    public static void main(String[] args) {
        // CSV 파일에서 상품 목록 읽어오기
        Set<Product> productSet = Product.readProductsFromCSV("task_cart/products.csv");

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        Product milk = productSet.stream().filter(p -> p.getKey().equals("milk")).findFirst().orElse(null);
        Product apple = productSet.stream().filter(p -> p.getKey().equals("apple")).findFirst().orElse(null);

        if (milk != null && apple != null) {
            myCart.addProduct(milk, 2);
            myCart.addProduct(apple, 1);
        } else {
            System.out.println("상품을 찾을 수 없습니다.");
        }

        // 장바구니에서 상품 제거
        myCart.removeProduct(milk, 1);

        // 장바구니에 현재 담긴 상품들을 출력
        myCart.showItems();
    }
}
