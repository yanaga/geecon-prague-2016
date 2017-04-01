package clean;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrderNumber implements Serializable, Formattable {

    private final Integer value;

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
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d", value);
    }

    public Integer toInteger() {
        return value;
    }

}
