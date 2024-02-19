package com.example.membership.adapter.in.web;

import com.example.membership.application.port.in.RegisterMembershipCommand;
import com.example.membership.application.port.in.RegisterMembershipUseCase;
import com.example.membership.domain.Membership;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@WebMvcTest(RegisterMembershipController.class)
public class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterMembershipUseCase registerMembershipUseCase;

    @Captor
    private ArgumentCaptor<RegisterMembershipCommand> commandCaptor;

    @Test
    public void testRegisterMembership() throws Exception {
        RegisterMembershipRequest request = new RegisterMembershipRequest("name", "address", "email@example.com", false);

        Membership expectedMembership = Membership.generateMember(
                Membership.MembershipId.from("1"),
                Membership.MembershipName.from("name"),
                Membership.MembershipEmail.from("email@example.com"),
                Membership.MembershipAddress.from("address"),
                Membership.MembershipIsValid.from(true),
                Membership.MembershipIsCorp.from(false)
        );

        given(registerMembershipUseCase.registerMembership(any(RegisterMembershipCommand.class))).willReturn(expectedMembership);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/membership/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.membershipId").value(expectedMembership.getMembershipId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedMembership.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(expectedMembership.getEmail()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(expectedMembership.getAddress()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value(expectedMembership.isValid()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.corp").value(expectedMembership.isCorp()));

        verify(registerMembershipUseCase).registerMembership(commandCaptor.capture());
        RegisterMembershipCommand capturedCommand = commandCaptor.getValue();

        // Command 객체 검증
        assert capturedCommand.getName().equals(request.getName());
        assert capturedCommand.getAddress().equals(request.getAddress());
        assert capturedCommand.getEmail().equals(request.getEmail());
        assert capturedCommand.isCorp() == request.isCorp();
    }
}