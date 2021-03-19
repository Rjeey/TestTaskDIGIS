package org.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(description = "User JPA Entity class")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 5454750574134271443L;

    @ApiModelProperty(notes = "User ID maps to Primary Key", example = "1", required = true, position = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ApiModelProperty(notes = "Unique Login of your User", example = "Rjeey", required = true, position = 1)
    @Column(unique = true)
    private String login;
    @ApiModelProperty(notes = "Full Name of your User", example = "John Smith", required = true, position = 2)
    private String fullName;
    @ApiModelProperty(notes = "Birth Day of your User", example = "2000-05-09", required = true, position = 3)
    private Date dob;
    @ApiModelProperty(notes = "Gender of your User", example = "Swagger", required = true, position = 4)
    private Gender gender;


    public User(String login, String fullName, Date dob, Gender gender) {
        this.login = login;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
    }
}
