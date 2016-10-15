package clean;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void of() throws Exception {
        Order order = Order.of(OrderNumber.of(1));
        BigDecimal value = order.getItems().getValue();
        assertThat(value, equalTo(BigDecimal.ZERO));
        order.apply(OrderItemOperations.DISCOUNT);
    }

}