package day01;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream()
                .filter(order->order.getStatus().equals(status))
                .toList();
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(order->order.getStatus().equals(status))
                .count();
    }

    public List<Product> findProductsOverPrice(int amount){
        return orders.stream()
                .flatMap(o->o.getProducts().stream())
                .filter(product->product.getPrice()>amount)
                .toList();
    }

    public String orderToString(Order o){
        return o.toString();
    }

    public List<Order> getOrdersBetweenDates(LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(order->(start.isBefore(order.getOrderDate()) && end.isAfter(order.getOrderDate())))
                .toList();
    }


    public List<Order> sortOrdersByStatusAndOrderDate(){
        return orders.stream()
                .sorted(Comparator.comparing(Order::getStatus).thenComparing(Order::getOrderDate))
                .toList();
    }

    public boolean isOrderWithLessProductThan(int number){
        return  orders.stream()
                .anyMatch(order-> order.getProducts().size()<number);
    }


    public Order getOrderWithMaxNumberOfProducts(){
        return  orders.stream()
                .sorted(Comparator.comparing(order-> order.getProducts().size(),Comparator.reverseOrder()))
                .findFirst().get();
    }

    public List<Order> getOrdersWithProductInCategory(String category){
        return orders.stream()
                .filter(order->order.getProducts().stream().anyMatch(product -> product.getCategory().equals(category)))
                .toList();
    }







}
