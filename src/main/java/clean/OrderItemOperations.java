package clean;

import java.math.BigDecimal;

public enum OrderItemOperations implements OrderItemOperation {
    DISCOUNT {
        @Override
        public OrderItem apply(OrderItem item) {
            return OrderItem.of(item.getProduct(), item.getAmount(), item.getValue().multiply(new BigDecimal("0.9")));
        }
    }

}
