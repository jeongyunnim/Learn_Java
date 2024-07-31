package com.easybytes.accounts.controller;

import com.easybytes.accounts.dto.CustomerDetailsDto;
import com.easybytes.accounts.dto.ErrorResponseDto;
import com.easybytes.accounts.service.ICustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "REST APIs for Customer in easy bank",
        description = "REST APIs in EazyBank to FETCH customer details"
)
@ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(
                schema = @Schema(implementation = ErrorResponseDto.class)
        )
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
// `/api/v1`또는 `/api/v2`와 같이 버전을 명시하는 것이 좋다.
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final ICustomersService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Operation(
            summary = "Fetch Customer REST API",
            description = "REST API to fetch Customer details based on a mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestHeader("eazybank-correlation-id") String correlationId,
                                                                   @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                                   String mobileNumber) {
        logger.debug("eazyBank-correlation-id: {}", correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomerDetails(mobileNumber, correlationId));
    }

}
