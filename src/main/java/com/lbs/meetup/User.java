package com.lbs.meetup;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Document(collection = "meetup_users")
public class User {

    @Id
    private String id;

    private String username;
    private LocalDate birthDate;

    public User(String username, LocalDate birthDate) {
        this.username = username;
        this.birthDate = birthDate;
    }
}
