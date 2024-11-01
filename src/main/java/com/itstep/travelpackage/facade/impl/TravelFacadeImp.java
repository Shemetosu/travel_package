package com.itstep.travelpackage.facade.impl;

import com.itstep.travelpackage.converter.TravelConverter;
import com.itstep.travelpackage.converter.TravelFeedConverter;
import com.itstep.travelpackage.converter.TravelTransportConverter;
import com.itstep.travelpackage.converter.TravelTypeConverter;
import com.itstep.travelpackage.facade.TravelFacade;
import com.itstep.travelpackage.model.dto.TravelDto;
import com.itstep.travelpackage.model.dto.TravelFeedDto;
import com.itstep.travelpackage.model.dto.TravelTransportDto;
import com.itstep.travelpackage.model.dto.TravelTypeDto;
import com.itstep.travelpackage.model.dto.create.TravelCreateDto;
import com.itstep.travelpackage.model.dto.create.TravelFeedCreateDto;
import com.itstep.travelpackage.model.dto.create.TravelTransportCreateDto;
import com.itstep.travelpackage.model.dto.create.TravelTypeCreateDto;
import com.itstep.travelpackage.model.dto.update.TravelFeedUpdateDto;
import com.itstep.travelpackage.model.dto.update.TravelTransportUpdateDto;
import com.itstep.travelpackage.model.dto.update.TravelTypeUpdateDto;
import com.itstep.travelpackage.model.dto.update.TravelUpdateDto;
import com.itstep.travelpackage.model.entity.Travel;
import com.itstep.travelpackage.service.TravelFeedService;
import com.itstep.travelpackage.service.TravelService;
import com.itstep.travelpackage.service.TravelTransportService;
import com.itstep.travelpackage.service.TravelTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TravelFacadeImp implements TravelFacade {

    private final TravelService travelService;
    private final TravelTypeService travelTypeService;
    private final TravelTransportService travelTransportService;
    private final TravelFeedService travelFeedService;
    private final TravelConverter travelConverter;
    private final TravelTypeConverter travelTypeConverter;
    private final TravelTransportConverter travelTransportConverter;
    private final TravelFeedConverter travelFeedConverter;

    //---

    @Override
    public TravelDto findOneTravel(Long id) {
        return travelConverter.convert(travelService.findOne(id));
    }

    @Override
    public TravelDto createTravel(TravelCreateDto dto) {
        Travel travel = travelConverter.convert(dto);
        travel.setTravelType(travelTypeService.findOne(dto.getTravelTypeId()));
        travel.setTravelTransport(travelTransportService.findOne(dto.getTravelTransportId()));
        travel.setTravelFeed(travelFeedService.findOne(dto.getTravelFeedId()));
        travel.setTravelFeed(travelFeedService.findOne(dto.getDaysCount()));
        return travelConverter.convert(
                travelService.create(
                        travelConverter.convert(dto)
                )
        );
    }

    @Override
    public TravelDto updateTravel(TravelUpdateDto dto) {
        Travel travel = travelService.findOne(dto.getId());
        travel = travelConverter.convert(dto);
        travel.setTravelType(travelTypeService.findOne(dto.getTravelTypeId()));
        travel.setTravelTransport(travelTransportService.findOne(dto.getTravelTransportId()));
        travel.setTravelFeed(travelFeedService.findOne(dto.getDaysCount()));
        return travelConverter.convert(travelService.update(travel));
    }

    @Override
    public void removeTravel(Long id) {
        travelService.remove(id);
    }

    //---

    @Override
    public TravelTypeDto findOneTravelType(Long id) {
        return travelTypeConverter.convert(travelTypeService.findOne(id));
    }

    @Override
    public TravelTypeDto createTravelType(TravelTypeCreateDto dto) {
        return travelTypeConverter.convert(
                travelTypeService.create(
                        travelTypeConverter.convert(dto)
                )
        );
    }

    @Override
    public TravelTypeDto updateTravelType(TravelTypeUpdateDto dto) {
        return null;
    }

    @Override
    public void removeTravelType(Long id) {
        travelTypeService.remove(id);
    }

    //---

    @Override
    public TravelTransportDto findOneTravelTransport(Long id) {
        return travelTransportConverter.convert(travelTransportService.findOne(id));
    }

    @Override
    public TravelTransportDto createTravelTransport(TravelTransportCreateDto dto) {
        return travelTransportConverter.convert(
                travelTransportService.create(
                        travelTransportConverter.convert(dto)
                )
        );
    }

    @Override
    public TravelTransportDto updateTravelTransport(TravelTransportUpdateDto dto) {
        return null;
    }

    @Override
    public void removeTravelTransport(Long id) {
        travelTransportService.remove(id);
    }

    //---

    @Override
    public TravelFeedDto findOneTravelFeed(Long id) {
        return travelFeedConverter.convert(travelFeedService.findOne(id));
    }

    @Override
    public TravelFeedDto createTravelFeed(TravelFeedCreateDto dto) {
        return travelFeedConverter.convert(
                travelFeedService.create(
                        travelFeedConverter.convert(dto)
                )
        );
    }

    @Override
    public TravelFeedDto updateTravelFeed(TravelFeedUpdateDto dto) {
        return null;
    }

    @Override
    public void removeTravelFeed(Long id) {
        travelFeedService.remove(id);
    }
}
