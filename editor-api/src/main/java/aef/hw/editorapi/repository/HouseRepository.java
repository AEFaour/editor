package aef.hw.editorapi.repository;

import aef.hw.editorapi.domain.House;
import aef.hw.editorapi.dto.HouseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("SELECT new aef.hw.editorapi.dto.HouseDTO(h.id, h.article, h.url, h.createdAt) FROM House h")
    Page<HouseDTO> findHouses(Pageable pageable);
}
