package clean;

import java.math.BigDecimal;

public enum OrderOperations implements OrderOperation {
    DISCOUNT {
        @Override
        public OrderItem apply(OrderItem item) {
            return OrderItem.of(item.getProduct(), item.getQuantity(),
                    item.getValue().multiply(new BigDecimal("0.9")));
        }
    };
}
