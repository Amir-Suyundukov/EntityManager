package ru.suyundukov.MyProject.entityTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.suyundukov.MyProject.Repository.CommissionRateJpaRepository;
import ru.suyundukov.MyProject.Repository.CommissionRateRepository;
import ru.suyundukov.MyProject.dto.CommissionRateDto;
import ru.suyundukov.MyProject.entity.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CommissionRateIntegrationTest {

    @Autowired
    protected CommissionRateRepository commissionRateRepository;
    @Autowired
    protected CommissionRateJpaRepository commissionRateJpaRepository;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        commissionRateJpaRepository.deleteAll();
    }

    @Test
    void getCommissionRate_successfully() throws Exception {
        createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));

        MvcResult result = mockMvc.perform(get("/tes/AF1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        CommissionRateDto commissionRateDto = getFromResponse(result, CommissionRateDto.class);
        assertEquals("AF1", commissionRateDto.getAfId());
    }

    @Test
    void getCommissionRateByAfId_successfully() throws Exception {
        createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));

        MvcResult result = mockMvc.perform(get("/tes/AF1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        CommissionRateDto commissionRateDto = getFromResponse(result, CommissionRateDto.class);
        assertEquals("AF1", commissionRateDto.getAfId());
        assertEquals("USD", commissionRateDto.getCurrency().getCurrencyCode());
    }

    @Test
    void getCommissionRateByLmId_successfully() throws Exception {
    createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));

    MvcResult result = mockMvc.perform(get("/tes/byLmId")
            .header("lmId", "LM1"))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    CommissionRateDto commissionRateDto = getFromResponse(result, CommissionRateDto.class);
    assertEquals("LM1", commissionRateDto.getLmId());
    }

    @Test
    void findCommissionRateByFilter_successfully() throws Exception {
        createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));
        createCommissionRate("LM2", LocalDate.now(), LocalDate.now().plusDays(30));
        CommissionRateFilter filter = new CommissionRateFilter();
        filter.setLmId("LM1");

        MvcResult result = mockMvc.perform(post("/tes/filter")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        List<CommissionRateDto> commissionRateDtos = getListFromResponse(result, CommissionRateDto.class);
        assertFalse(commissionRateDtos.isEmpty());
        assertEquals(1, commissionRateDtos.size());
        assertEquals("LM1", commissionRateDtos.get(0).getLmId());
    }

    @Test
    void findCommissionRateByFilter_notFound() throws Exception {
        createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));
        createCommissionRate("LM2", LocalDate.now(), LocalDate.now().plusDays(30));
        CommissionRateFilter filter = new CommissionRateFilter();
        filter.setLmId("LM333");

        MvcResult result = mockMvc.perform(post("/tes/filter")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        List<CommissionRateDto> commissionRateDtos = getListFromResponse(result, CommissionRateDto.class);
        assertTrue(commissionRateDtos.isEmpty());
        assertEquals(0, commissionRateDtos.size());
    }

    @Test
    void findCommissionRateByLmId_notFound() throws Exception{
        createCommissionRate("LM1", LocalDate.now(), LocalDate.now().plusDays(30));
        createCommissionRate("LM2", LocalDate.now(), LocalDate.now().plusDays(30));

        mockMvc.perform(get("/tes/byLmId")
                        .header("lmId", "LM99"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getCommissionRateByDate() throws Exception{
        createCommissionRate("LM1", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 1));
        createCommissionRate("LM2", LocalDate.of(2025, 2, 2), LocalDate.of(2025, 3, 1));
        createCommissionRate("LM3", LocalDate.of(2025, 3, 2), LocalDate.of(2025, 4, 1));
        createCommissionRate("LM4", LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 28));

        MvcResult result = mockMvc.perform(get("/tes/date")
                        .param("startDate", "2025-01-01")
                        .param("endDate", "2025-03-01"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        List<CommissionRateDto> commissionRateDtos = getListFromResponse(result, CommissionRateDto.class);

        assertEquals(3, commissionRateDtos.size());
        assertTrue(commissionRateDtos.stream().anyMatch(dto -> dto.getLmId().equals("LM1")));
        assertTrue(commissionRateDtos.stream().anyMatch(dto -> dto.getLmId().equals("LM2")));
        assertTrue(commissionRateDtos.stream().anyMatch(dto -> dto.getLmId().equals("LM4")));
        assertFalse(commissionRateDtos.stream().anyMatch(dto -> dto.getLmId().equals("LM3")));
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================


    private void createCommissionRate(String lmId, LocalDate startDate, LocalDate endDate) {
        CommissionRate commissionRate = new CommissionRate();
        commissionRate.setAfId("AF1");
        commissionRate.setLmId(lmId);
        commissionRate.setCurrency(Currency.getInstance("USD"));
        commissionRate.setFinancingStatus(FinancingStatus.UNFUNDED);
        commissionRate.setCommissionType(CommissionType.AD_REWARD);
        commissionRate.setIsSurcharge(false);
        commissionRate.setRateType(RateType.FIXED_AMOUNT);
        commissionRate.setStartDate(LocalDate.now());
        commissionRate.setStatus(CommissionRateStatus.OPEN);
        commissionRate.setStartDate(startDate);
        commissionRate.setEndDate(endDate);

        CreationInfo creationInfo = new CreationInfo();
        creationInfo.setCreateUserFullName("Default User");
        creationInfo.setCreateUserLogin("USER");
        commissionRate.setCreationInfo(creationInfo);

        commissionRateRepository.save(commissionRate);
    }

    private <T> List<T> getListFromResponse(MvcResult result, Class<?>... classes) {
        try {
            return getFromResponse(result, List.class, classes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T getFromResponse(MvcResult result, Class<?> clazz, Class<?>... classes) {
        return mapToObject(getStringFromResponse(result), clazz, classes);
    }

    protected <T> T mapToObject(String string, Class<?> clazz, Class<?>... classes) {
        try {
            if (classes.length == 0) {
                return (T) objectMapper.readValue(string, clazz);
            }

            Class<?>[] newClasses = ArrayUtils.addFirst(classes, clazz);
            JavaType currentType = null;
            for (int i = newClasses.length - 1; i > 0; i--) {
                if (currentType == null) {
                    currentType = objectMapper.getTypeFactory().constructParametricType(newClasses[i - 1], newClasses[i]);
                } else {
                    currentType = objectMapper.getTypeFactory().constructParametricType(newClasses[i - 1], currentType);
                }
            }

            return objectMapper.readValue(string, currentType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getStringFromResponse(MvcResult result) {
        try {
            return result.getResponse().getContentAsString(UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
// ===================================================================================================================
    // = File utils
    // ===================================================================================================================

    protected String readFile(String fileName) {
        try {
            URL resource = getClass().getResource(fileName);
            assert resource != null;
            return Files.readString(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected <T> T readFromFile(String fileName) {
        String content = readFile(fileName);
        try {
            return objectMapper.readValue(content, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> T readFromFile(String fileName, Class<?> clazz, Class<?>... classes) {
        String content = readFile(fileName);
        return mapToObject(content, clazz, classes);
    }

    protected <T> List<T> readListFromFile(String fileName, Class<?>... classes) {
        return readFromFile(fileName, List.class, classes);
    }
}
