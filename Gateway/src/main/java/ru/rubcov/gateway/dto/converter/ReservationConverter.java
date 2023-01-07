package ru.rubcov.gateway.dto.converter;

import ru.rubcov.gateway.dto.*;
import ru.rubcov.gateway.dto.ReservationDTO;
import ru.rubcov.gateway.dto.PaymentInfo;
import java.util.UUID;

public class ReservationConverter {
    public static ReservationDTO toReservationDTO(PaymentDTO paymentDTO, CreateReservationRequest request,
                                                  Integer hotelId) {
        return new ReservationDTO()
                .setReservationUid(UUID.randomUUID())
                .setPaymentUid(paymentDTO.getPaymentUid())
                .setHotelId(hotelId)
                .setStatus(paymentDTO.getStatus())
                .setStartDate(request.getStartDate())
                .setEndDate(request.getEndDate());
    }

    public static ReservationResponse toReservationResponse(ReservationDTO reservationDTO,
                                                            HotelInfo hotelInfo,
                                                            PaymentInfo paymentInfo) {
        return new ReservationResponse()
                .setReservationUid(reservationDTO.getReservationUid())
                .setHotel(hotelInfo)
                .setStartDate(reservationDTO.getStartDate())
                .setEndDate(reservationDTO.getEndDate())
                .setStatus(reservationDTO.getStatus())
                .setPayment(paymentInfo);
    }

    public static CreateReservationResponse fromReservationDTOToCreateReservationResponse(ReservationDTO reservationDTO,
                                                                                          UUID hotelUid, Integer discount,
                                                                                          PaymentInfo paymentInfo) {
        return new CreateReservationResponse()
                .setReservationUid(reservationDTO.getReservationUid())
                .setHotelUid(hotelUid)
                .setStartDate(reservationDTO.getStartDate())
                .setEndDate(reservationDTO.getEndDate())
                .setDiscount(discount)
                .setStatus(reservationDTO.getStatus())
                .setPayment(paymentInfo);
    }
}
