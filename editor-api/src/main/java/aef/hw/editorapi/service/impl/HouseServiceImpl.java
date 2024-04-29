package aef.hw.editorapi.service.impl;

import aef.hw.editorapi.dto.HouseDTO;
import aef.hw.editorapi.dto.HousesDTO;
import aef.hw.editorapi.repository.HouseRepository;
import aef.hw.editorapi.service.HouseServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseServiceInterface {

    private final HouseRepository houseRepository;

    @Override
    @Transactional(readOnly = true)
    public HousesDTO getHouses(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<HouseDTO> housePage = this.houseRepository.findHouses(pageable);
        return new HousesDTO(housePage);
    }
}
