package aef.hw.editorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class HousesDTO {

    private List<HouseDTO> data;
    private Long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public HousesDTO(Page<HouseDTO> housePage) {
        this.setData(housePage.getContent());
        this.setTotalElements(housePage.getTotalElements());
        this.setTotalPages(housePage.getTotalPages());
        this.setCurrentPage(housePage.getNumber() + 1);
        this.setFirst(housePage.isFirst());
        this.setLast(housePage.isLast());
        this.setHasNext(housePage.hasNext());
        this.setHasPrevious(housePage.hasPrevious());
    }

}
