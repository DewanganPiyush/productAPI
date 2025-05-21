package com.healthcatalyst.productapi.entity;

import lombok.*;

import org.antlr.v4.runtime.Token;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse {

    private String jwtToken;

    private String username;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String jwtToken;
        private String username;

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            JwtResponse resp = new JwtResponse();      // use the existing no-args ctor
            resp.setJwtToken(this.jwtToken);           // set fields via setters
            resp.setUsername(this.username);
            return resp;
        }
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
