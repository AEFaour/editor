package aef.hw.editorapi.mapper;

import aef.hw.editorapi.domain.House;
import aef.hw.editorapi.dto.HouseDTO;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    public HouseDTO toDTO(House house) {
        return HouseDTO.builder()
                .id(house.getId())
                .article(house.getArticle())
                .url(house.getUrl())
                .createdAt(house.getCreatedAt())
                .build();
    }
}
