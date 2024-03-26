package com.example.jwt.domain.orderposition.dto;

import com.example.jwt.domain.orderposition.OrderPosition;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-09T14:57:56+0100",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (JetBrains s.r.o.)"
)
@Component
public class OrderPositionMapperImpl implements OrderPositionMapper {

    @Override
    public OnlyAmountDTO orderpositionToOnlyAmountDTO(OrderPosition orderPosition) {
        if ( orderPosition == null ) {
            return null;
        }

        OnlyAmountDTO onlyAmountDTO = new OnlyAmountDTO();

        onlyAmountDTO.setAmount( orderPosition.getAmount() );

        return onlyAmountDTO;
    }
}
