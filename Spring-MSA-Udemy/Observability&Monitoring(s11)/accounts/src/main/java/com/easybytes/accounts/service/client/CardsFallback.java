package com.easybytes.accounts.service.client;

import com.easybytes.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null; // 실무에서는 비즈니스로직에 따라 변경해야 한다.
    }
}
