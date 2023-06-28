package com.richrb97.users1.document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
@Data
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;
    private String address;
    private String rol;
}
