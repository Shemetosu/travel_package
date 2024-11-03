package com.itstep.travel.repository.specification;

import com.itstep.travel.model.dto.TravelFilterDto;
import com.itstep.travel.model.entity.Travel;
import com.itstep.travel.model.entity.TravelFeed;
import com.itstep.travel.model.entity.TravelTransport;
import com.itstep.travel.model.entity.TravelType;
import jakarta.persistence.criteria.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TravelSpecification {

    public static Specification<Travel> findAll(TravelFilterDto filter) {

        return (travel, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>(4);
            if (filter.typeId() != null) {
                predicateList.add(
                        criteriaBuilder.equal(travel.get("travelTypeId"), filter.typeId())
                );
            }
            if (filter.transportId() != null) {
                predicateList.add(
                        criteriaBuilder.equal(travel.get("travelTransportId"), filter.transportId())
                );
            }
            if (filter.feedId() != null) {
                predicateList.add(
                        criteriaBuilder.equal(travel.get("travelFeedId"), filter.feedId())
                );
            }
            if (filter.daysCountFrom() != null & filter.daysCountTo() != null) {
                predicateList.add(
                        criteriaBuilder.between(travel.get("daysCount"), filter.daysCountFrom(), filter.daysCountTo())
                );
            }
            if (filter.daysCountFrom() != null & filter.daysCountTo() == null) {
                predicateList.add(
                        criteriaBuilder.greaterThanOrEqualTo(travel.get("daysCount"), filter.daysCountFrom())
                );
            }
            if (filter.daysCountFrom() == null & filter.daysCountTo() != null) {
                predicateList.add(
                        criteriaBuilder.lessThanOrEqualTo(travel.get("daysCount"), filter.daysCountTo())
                );
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }

    public static Specification<TravelType> findAllByTravelType(Long typeId) {
        return (travel, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(travel.get("travelTypeId"), typeId);
    }

    public static Specification<TravelTransport> findAllByTravelTransport(Long transportId) {
        return (travel, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(travel.get("travelTransportId"), transportId);
    }

    public static Specification<TravelFeed> findAllByTravelFeed(Long feedId) {
        return (travel, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(travel.get("travelTransportId"), feedId);
    }
}
