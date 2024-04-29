package aef.hw.editorapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "houses")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @SequenceGenerator(name = "hs_id_seq_gen", sequenceName = "hs_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hs_id_seq_gen")
    private Long id;

    @Column(nullable = false)
    private String article;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Instant createdAt;
}
