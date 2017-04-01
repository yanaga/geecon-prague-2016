package clean;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;

@Embeddable
public class OrderItem implements Serializable {

    private String product;

    private Integer quantity;

    private BigDecimal value;

    private OrderItem(String product, Integer quantity, BigDecimal value) {
        this.product = product;
        this.quantity = quantity;
        this.value = value;
    }

    public static OrderItem of(String product, Integer quantity, BigDecimal value) {
        checkNotNull(product);
        checkNotNull(quantity);
        checkNotNull(value);
        return new OrderItem(product, quantity, value);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

}
