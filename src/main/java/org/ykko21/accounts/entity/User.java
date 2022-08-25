package org.ykko21.accounts.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ykko21.accounts.dto.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "app_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "emailaddress")
    private String email;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .userId(this.userId)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .build();
    }
}
