package com.unitalk.member.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String userId;
    private String username;
    private String role;
    private String userType;
    private String token;

    public JwtResponse(String userId, String username, String role, String userType, String token) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.userType = userType;
        this.token = token;
    }

    // getters and setters
}
