package aef.hw.editorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

    private Long id;

    private String article;

    private String url;

    private Instant createdAt;
}
