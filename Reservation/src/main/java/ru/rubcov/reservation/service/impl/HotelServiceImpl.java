package ru.rubcov.reservation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rubcov.reservation.dto.HotelResponse;
import ru.rubcov.reservation.model.HotelEntity;
import ru.rubcov.reservation.repository.HotelRepository;
import ru.rubcov.reservation.service.HotelService;
import ru.rubcov.reservation.service.converter.HotelConverter;

import java.sql.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Transactional(readOnly = true)
    public Page<HotelResponse> getHotels(Pageable pageable) {
        return hotelRepository
                .findAll(pageable)
                .map(HotelConverter::fromHotelsEntityToHotelResponse);
    }

    @Transactional(readOnly = true)
    public HotelResponse getHotelByHotelId(Integer hotelId) {
        return HotelConverter.fromHotelsEntityToHotelResponse(hotelRepository
                .getHotelById(hotelId));
    }

    @Transactional(readOnly = true)
    public HotelResponse getHotelByHotelUid(UUID hotelUid) {
        return HotelConverter.fromHotelsEntityToHotelResponse(hotelRepository
                .getHotelByUid(hotelUid));
    }

    @Transactional(readOnly = true)
    public Integer getHotelIdByHotelUid(UUID hotelUid) {
        return hotelRepository.getHotelIdByHotelUid(hotelUid);
    }

    @Transactional(readOnly = true)
    public Integer getHotelDatePrice(UUID hotelUid, Date startDate, Date endDate) {
        HotelEntity hotelEntity = hotelRepository.getHotelByUid(hotelUid);
        if (hotelEntity == null)
            return null;

        HotelResponse hotelResponse = HotelConverter.fromHotelsEntityToHotelResponse(hotelEntity);
        long diffMillis = endDate.getTime() - startDate.getTime();
        long days = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
        return Math.toIntExact(days * hotelResponse.getPrice());
    }
}
