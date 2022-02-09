package by.vironit.scrabets.calculatorbackend.controller;

import by.vironit.scrabets.calculatorbackend.dto.CalcRequestDto;
import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(CalculationController.class)
class CalculationControllerTest {

    @MockBean
    private CalculationService calculationService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CalcRequestDto> jsonRequest;

    @Autowired
    private JacksonTester<Double> jsonResponse;

    @Test
    void whenPostValidDtoToCalculate_thenStatusIsOk() throws Exception {
        // given
        CalcRequestDto requestDto = new CalcRequestDto(20d, 30d, "+");
        Double expectedResponse = 50d;
        given(calculationService.calculate(
                eq(requestDto.getOperand1()),
                eq(requestDto.getOperand2()),
                eq(OperationType.findBy(requestDto.getOperation()))
        )).willReturn(expectedResponse);

        // when
        MockHttpServletResponse actualResponse = mvc.perform(
                post("/api/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest.write(requestDto).getJson())
        ).andReturn().getResponse();

        // then
        then(actualResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(actualResponse.getContentAsString()).isEqualTo(jsonResponse.write(expectedResponse).getJson());
    }

    @Test
    void whenPostInvalidDtoToCalculate_thenStatusIsBadRequest() throws Exception {
        // given
        CalcRequestDto requestDto = new CalcRequestDto(20d, 30d, "");

        // when
        MockHttpServletResponse actualResponse = mvc.perform(
                post("/api/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest.write(requestDto).getJson())
        ).andReturn().getResponse();

        // then
        then(actualResponse.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}