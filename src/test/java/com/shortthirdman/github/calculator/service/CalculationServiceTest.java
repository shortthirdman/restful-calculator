package com.shortthirdman.github.calculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shortthirdman.github.calculator.dto.Request;
import com.shortthirdman.github.calculator.dto.Response;
import org.junit.jupiter.api.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final CalculationService SERVICE = new CalculationService();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @TestFactory
    Stream<DynamicTest> testCalculateService() {
        int counter = 0;
//        List<Stream<DynamicTest>> test = Collections.singletonList(generateTest("(+)", counter++, "request/1.json", "response/1.json"));
        List<Stream<DynamicTest>> test = Arrays.asList(
                generateTest("(+)", counter++, "request/1.json", "response/1.json"),
                generateTest("(+)", counter++, "request/2.json", "response/2.json"),
                generateTest("(+)", counter++, "request/3.json", "response/3.json")
        );
        return test
                .stream()
                .flatMap(stream -> stream);
    }

    private Stream<DynamicTest> generateTest(String tag, int counter, String requestPath, String responsePath) {
        return Stream.of(createTest(tag, counter, requestPath, responsePath));
    }

    private DynamicTest createTest(String tag, int counter, String requestPath, String responsePath) {
        return DynamicTest.dynamicTest(tag + " | Calculation test case #" + counter, () -> {
            var request = this.getRequest(requestPath);
            var expected = this.getResponse(responsePath);
            var actual = SERVICE.calculate(request);
            Assertions.assertEquals(expected.result(), actual.result());
        });
    }

    private Request getRequest(String path) {
        try {
            byte[] content = Files.readAllBytes(Paths.get(CalculationServiceTest.class.getClassLoader().getResource(path).getPath()));
            return OBJECT_MAPPER.readValue(new String(content, StandardCharsets.UTF_8), Request.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Response getResponse(String path) {
        try {
            byte[] content = Files.readAllBytes(Paths.get(CalculationServiceTest.class.getClassLoader().getResource(path).getPath()));
            return OBJECT_MAPPER.readValue(new String(content, StandardCharsets.UTF_8), Response.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}