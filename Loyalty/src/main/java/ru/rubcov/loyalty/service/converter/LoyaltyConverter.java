package ru.rubcov.loyalty.service.converter;

import ru.rubcov.loyalty.dto.LoyaltyDTO;
import ru.rubcov.loyalty.dto.LoyaltyIntoResponse;
import ru.rubcov.loyalty.dto.enums.StatusEnum;
import ru.rubcov.loyalty.model.LoyaltyEntity;

public class LoyaltyConverter {
    public static LoyaltyDTO fromLoyaltyEntityToLoyaltyDTO(LoyaltyEntity loyaltyEntity) {
        return new LoyaltyDTO()
                .setId(loyaltyEntity.getId())
                .setUsername(loyaltyEntity.getUsername())
                .setReservationCount(loyaltyEntity.getReservationCount())
                .setStatus(StatusEnum.valueOf(loyaltyEntity.getStatus()))
                .setDiscount(loyaltyEntity.getDiscount());
    }

    public static LoyaltyEntity fromLoyaltyDTOToLoyaltyEntity(LoyaltyDTO loyaltyDTO) {
        return new LoyaltyEntity()
                .setId(loyaltyDTO.getId())
                .setUsername(loyaltyDTO.getUsername())
                .setReservationCount(loyaltyDTO.getReservationCount())
                .setStatus(loyaltyDTO.getStatus().name())
                .setDiscount(loyaltyDTO.getDiscount());
    }

    public static LoyaltyIntoResponse fromLoyaltyDTOToLoyaltyInfoResponse(LoyaltyDTO loyaltyDTO) {
        return new LoyaltyIntoResponse()
                .setStatus(loyaltyDTO.getStatus())
                .setDiscount(loyaltyDTO.getDiscount())
                .setReservationCount(loyaltyDTO.getReservationCount());
    }
}
