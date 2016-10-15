package clean;

import com.google.common.base.MoreObjects;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Embeddable
public class OrderItem implements Serializable {

    private String product;

    private Integer amount;

    private BigDecimal value;

    private OrderItem(String product, Integer amount, BigDecimal value) {
        this.product = product;
        this.amount = amount;
        this.value = value;
    }

    public static OrderItem of(String product, Integer amount, BigDecimal value) {
        checkNotNull(product);
        checkNotNull(amount);
        checkArgument(amount > 0);
        checkNotNull(value);
        checkArgument(value.compareTo(BigDecimal.ZERO) > 0);
        return new OrderItem(product, amount, value);
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
        return MoreObjects.toStringHelper(this)
                .add("product", product)
                .add("amount", amount)
                .add("value", value)
                .toString();
    }

    public String getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getValue() {
        return value;
    }

}
