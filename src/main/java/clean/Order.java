package clean;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private OrderNumber number;

    @ElementCollection
    private List<OrderItem> items = Lists.newLinkedList();

    @ElementCollection
    private List<OrderItem> discountItems = Lists.newLinkedList();

    private Order(OrderNumber number) {
        this.number = number;
    }

    public static Order of(OrderNumber number) {
        checkNotNull(number);
        return new Order(number);
    }

    public void addItem(OrderItem item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void apply(OrderItemOperation operation) {
        items = items.stream()
                .map(operation)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public OrderNumber getNumber() {
        return number;
    }

    public OrderItems getItems() {
        return OrderItems.of(items);
    }

    public OrderItems getDiscountedItems() {
        return OrderItems.of(discountItems);
    }

}
