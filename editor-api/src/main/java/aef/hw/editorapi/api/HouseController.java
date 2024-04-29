package aef.hw.editorapi.api;

import aef.hw.editorapi.dto.HousesDTO;
import aef.hw.editorapi.service.impl.HouseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseServiceImpl houseService;

    @GetMapping
    public HousesDTO getAllHouses(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return this.houseService.getHouses(page);
    }
}
