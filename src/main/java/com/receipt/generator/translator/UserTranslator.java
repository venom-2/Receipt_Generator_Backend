package com.receipt.generator.translator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.generator.dto.UserRequest;
import com.receipt.generator.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserTranslator {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public User userRequestToUser(UserRequest userRequest) {
        return objectMapper.convertValue(userRequest, User.class);
    }
}
