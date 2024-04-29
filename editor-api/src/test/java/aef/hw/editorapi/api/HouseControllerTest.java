package aef.hw.editorapi.api;

import aef.hw.editorapi.domain.House;
import aef.hw.editorapi.repository.HouseRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:16.2:///demo"
})
class HouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HouseRepository houseRepository;

    @BeforeEach
    void setUp() {
        houseRepository.deleteAllInBatch();
        List<House> houses = new ArrayList<>();
        houses.add(House.builder().article("Java").url("https://www.java.com/fr/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Spring").url("https://spring.io/projects/spring-boot").createdAt(Instant.now()).build());
        houses.add(House.builder().article("ECMA").url("https://ecma-international.org").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Node JS").url("https://nodejs.org/en").createdAt(Instant.now()).build());
        houses.add(House.builder().article("NPM").url("https://www.npmjs.com/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Express JS").url("https://expressjs.com/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Next JS").url("https://nextjs.org/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("PostgreSQL").url("https://www.postgresql.org/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Posman").url("https://www.postman.com/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Docker").url("https://www.docker.com/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Kubernetes").url("https://kubernetes.io/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("GitHub").url("https://github.com/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Jenkins").url("https://www.jenkins.io/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("SonarQube").url("https://www.sonarsource.com/products/sonarqube/").createdAt(Instant.now()).build());
        houses.add(House.builder().article("Visual Studio Code").url("https://code.visualstudio.com/").createdAt(Instant.now()).build());

        houseRepository.saveAll(houses);
    }

    @ParameterizedTest
    @CsvSource({
            "15, 2, 1, true, false, true, false",
            "15, 2, 2, false, true, false, true"
    })
    void test_getAllHouses(int totalElements,
                           int totalPages,
                           int pageNumber,
                           boolean isFirst,
                           boolean isLast,
                           boolean hasNext,
                           boolean hasPrevious) throws Exception {
        mockMvc.perform(get(String.format("/api/houses?page=%s", pageNumber)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(pageNumber)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
    }
}