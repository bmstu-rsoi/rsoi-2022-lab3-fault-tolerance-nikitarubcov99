package ru.rubcov.gateway.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;
import ru.rubcov.gateway.dto.enums.UserStatusEnum;

@Data
@Validated
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoyaltyInfoResponse {
    private UserStatusEnum status;
    private Integer discount;
    private Integer reservationCount;
}
