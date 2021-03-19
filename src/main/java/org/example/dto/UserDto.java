package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Gender;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @ApiModelProperty(notes = "Unique Login of your User", example = "Rjeey", required = true, position = 1)
    @NotBlank(message = "Login can not be empty")
    private String login;
    @ApiModelProperty(notes = "Full Name of your User", example = "John Smith", required = true, position = 2)
    @NotBlank(message = "Full Name can not be empty")
    private String fullName;
    @ApiModelProperty(notes = "Birth Day of your User", example = "2000-05-09", required = true, position = 3)
    private Date dob;
    @ApiModelProperty(notes = "Gender of your User", example = "MALE", required = true, position = 4)
    private Gender gender;
}
