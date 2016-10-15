package clean;

import java.io.Serializable;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrderNumber implements Serializable {

    final Integer value;

    private OrderNumber(Integer value) {
        this.value = value;
    }

    public static OrderNumber of(Integer value) {
        checkNotNull(value);
        checkArgument(value > 0);
        return new OrderNumber(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderNumber) {
            OrderNumber other = (OrderNumber) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public Integer toInteger() {
        return value;
    }

}
