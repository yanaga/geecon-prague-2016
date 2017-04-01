package clean;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderNumberAttributeConverter implements AttributeConverter<OrderNumber, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderNumber attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toInteger();
    }

    @Override
    public OrderNumber convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return OrderNumber.of(dbData);
    }

}
