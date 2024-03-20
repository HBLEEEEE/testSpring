package com.example.demo;

import com.example.math.controller.MathController;
import com.example.math.service.MathService;
import com.example.member.controller.MemberController;
import com.example.member.dto.SigninDto;
import com.example.member.repository.MemberRepository;
import com.example.member.service.MemberService;
import com.example.search.controller.SearchController;
import com.example.search.service.SearchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberController memberController;

    @Mock
    private MathService mathService;

    @Autowired
    private MathController mathController;

    @Mock
    private SearchService searchService;

    @InjectMocks
    private SearchController searchController;

    @Test
    @DisplayName("템플릿 잘 들어가는 지 테스트")
    public void getRightTemplateByNumber() throws Exception {

        String number = "2";
        mockMvc.perform(MockMvcRequestBuilders.get("/toPass/{number}", number))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("number"))
                .andExpect(MockMvcResultMatchers.view().name("toPass"+number))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void testSignin_Success(){
        SigninDto signinDto = new SigninDto("test@example.com", "111111", 1, 30);

        when(memberRepository.findByEmail(signinDto.getEmail())).thenReturn(Optional.empty());

        assertEquals("success", memberController.signin(signinDto));
    }

    @Test
    @DisplayName("숫자계산 테스트")
    public void mathTest() throws Exception {

        int number = 5;
        int expected = 10;

        when(mathService.mutiple(number)).thenReturn(expected);
        int result = mathController.multiple(number);

        System.out.println("result = " + result);

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("검색 테스트")
    public void searchTest(){
        String searchThing = "test";
        String expectedResponse = "Expected response from search service";

        when(searchService.search(searchThing)).thenReturn(expectedResponse);

        String result = searchController.search(searchThing);

        assertEquals(expectedResponse, result);
    }
}
