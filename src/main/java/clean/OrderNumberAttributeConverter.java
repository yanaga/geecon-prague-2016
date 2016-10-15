package clean;

import javax.persistence.AttributeConverter;

public class OrderNumberAttributeConverter implements AttributeConverter<OrderNumber, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderNumber attribute) {
        if (attribute == null) {
            return null;
        } else {
            return attribute.value;
        }
    }

    @Override
    public OrderNumber convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        } else {
            return OrderNumber.of(dbData);
        }
    }

}
