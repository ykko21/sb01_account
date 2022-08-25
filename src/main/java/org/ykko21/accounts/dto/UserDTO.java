package org.ykko21.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ykko21.accounts.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    @JsonProperty("user_id")
    private String userId;
    private String firstname;
    private String lastname;
    private String email;

    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .build();
    }
}
