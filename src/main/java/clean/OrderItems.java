package clean;

import com.google.common.collect.ForwardingList;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class OrderItems extends ForwardingList<OrderItem> {

    private final List<OrderItem> delegate;

    private OrderItems(List<OrderItem> delegate) {
        this.delegate = delegate;
    }

    public static OrderItems of(List<OrderItem> delegate) {
        checkNotNull(delegate);
        return new OrderItems(delegate);
    }

    @Override
    protected List<OrderItem> delegate() {
        return delegate;
    }

    public Integer getQuantity() {
        return delegate.stream()
                .map(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    public BigDecimal getValue() {
        return delegate.stream()
                .map(OrderItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
