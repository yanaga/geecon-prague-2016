package clean;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testOf() {
        Order order = Order.of(OrderNumber.of(1));
        order.getItems().getQuantity();
        order.getDiscountedItems().getQuantity();
    }
}