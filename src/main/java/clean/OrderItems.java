package clean;

import com.google.common.collect.ForwardingList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderItems extends ForwardingList<OrderItem> implements Serializable {

    private final List<OrderItem> delegate;

    private OrderItems(List<OrderItem> delegate) {
        this.delegate = delegate;
    }

    static OrderItems of(List<OrderItem> value) {
        return new OrderItems(value);
    }

    @Override
    protected List<OrderItem> delegate() {
        return delegate;
    }

    public Integer getAmount() {
        return delegate.stream()
                .map(OrderItem::getAmount)
                .reduce(0, Integer::sum);
    }

    public BigDecimal getValue() {
        return delegate.stream()
                .map(OrderItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
