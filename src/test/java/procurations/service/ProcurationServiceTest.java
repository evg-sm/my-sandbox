package procurations.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import procurations.ProcurationTestData;
import procurations.exception.NotFoundException;
import procurations.model.Procuration;
import procurations.model.ProcurationDto;
import procurations.model.ProcurationState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static procurations.Matcher.ProcurationMatcher.assertMatch;
import static procurations.ProcurationTestData.getProcuration;

@SpringBootTest
public class ProcurationServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationService procurationService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveWithActiveTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.ACTIVE));
        Procuration actual = procurationService.get(created.getPoaId());
        log.info("Expected procuration {}", getProcuration(ProcurationState.ACTIVE));
        log.info("Actual procuration   {}", actual);
        assertMatch(actual, getProcuration(ProcurationState.ACTIVE));
        assertTrue(actual.getCreateDate().isBefore(LocalDateTime.now()));
        assertTrue(actual.getStartDate().isBefore(LocalDate.now()));
        assertTrue(actual.getExpirationDate().isAfter(LocalDate.now()));
        assertNull(actual.getCancelDate());
        assertNull(actual.getDeleteDate());
    }

    @Test
    void saveWithDeletedTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.DELETED));
        Procuration actual = procurationService.get(created.getPoaId());
        log.info("Expected procuration {}", getProcuration(ProcurationState.DELETED));
        log.info("Actual procuration   {}", actual);
        assertMatch(actual, getProcuration(ProcurationState.DELETED));
        assertTrue(actual.getCreateDate().isBefore(LocalDateTime.now()));
        assertTrue(actual.getStartDate().isBefore(LocalDate.now()));
        assertTrue(actual.getExpirationDate().isAfter(LocalDate.now()));
        assertNull(actual.getCancelDate());
        assertTrue(actual.getDeleteDate().isBefore(LocalDate.now()));
    }

    @Test
    void saveWithExpiredTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.EXPIRED));
        Procuration actual = procurationService.get(created.getPoaId());
        log.info("Expected procuration {}", getProcuration(ProcurationState.EXPIRED));
        log.info("Actual procuration   {}", actual);
        assertMatch(actual, getProcuration(ProcurationState.EXPIRED));
        assertTrue(actual.getCreateDate().isBefore(LocalDateTime.now()));
        assertTrue(actual.getStartDate().isBefore(LocalDate.now()));
        assertTrue(actual.getExpirationDate().isBefore(LocalDate.now()));
        assertNull(actual.getCancelDate());
        assertNull(actual.getDeleteDate());
    }

    @Test
    void saveWithCancelledTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.CANCELLED));
        Procuration actual = procurationService.get(created.getPoaId());
        log.info("Expected procuration {}", getProcuration(ProcurationState.CANCELLED));
        log.info("Actual procuration   {}", actual);
        assertMatch(actual, getProcuration(ProcurationState.CANCELLED));
        assertTrue(actual.getCreateDate().isBefore(LocalDateTime.now()));
        assertTrue(actual.getStartDate().isBefore(LocalDate.now()));
        assertTrue(actual.getExpirationDate().isAfter(LocalDate.now()));
        assertTrue(actual.getCancelDate().isBefore(LocalDate.now()));
        assertNull(actual.getDeleteDate());
    }

    @Test
    void saveWithNotStartedTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.NOT_STARTED));
        Procuration actual = procurationService.get(created.getPoaId());
        log.info("Expected procuration {}", getProcuration(ProcurationState.NOT_STARTED));
        log.info("Actual procuration   {}", actual);
        assertMatch(actual, getProcuration(ProcurationState.NOT_STARTED));
        assertTrue(actual.getCreateDate().isBefore(LocalDateTime.now()));
        assertTrue(actual.getStartDate().isAfter(LocalDate.now()));
        assertTrue(actual.getExpirationDate().isAfter(LocalDate.now()));
        assertNull(actual.getCancelDate());
        assertNull(actual.getDeleteDate());
    }

    @Test
    void getNotFoundTest() {
        assertThrows(NotFoundException.class, () -> procurationService.get(-1));
    }

    @Test
    void deleteTest() {
        Procuration created = procurationService.save(ProcurationTestData.getProcurationDto(ProcurationState.ACTIVE));
        Procuration actual = procurationService.get(created.getPoaId());
        assertNotNull(actual);
        procurationService.delete(created.getPoaId());
        assertThrows(NotFoundException.class, () -> procurationService.delete(created.getPoaId()));
    }

    @Test
    void deleteNotFoundTest() {
        assertThrows(NotFoundException.class, () -> procurationService.delete(-1));
    }

    @Test
    @SneakyThrows
    void serialize() {
        ProcurationDto procurationDto = ProcurationDto.builder()
                .principalClientId(11111)
                .attorneyClientId(22222222)
                .account("12312312")
                .state(ProcurationState.ACTIVE)
                .actions(new HashSet<>(Arrays.asList(11, 22)))
                .build();
        log.info(objectMapper.writeValueAsString(procurationDto));
    }
}
