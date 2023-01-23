package javaapi.react.project.javareact.dto;

import lombok.*;

@Getter
@Setter
public class EmployeeRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role = "user";
}
