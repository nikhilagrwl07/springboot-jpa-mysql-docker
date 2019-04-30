package com.fitness.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about credential")
public class CredentialRequest {

    @Size(min = 2, message = "User name should be at least 2 character")
    @ApiModelProperty(notes = "User name should be at least 2 character")
    private String username;

    private String password;

    private String firstName;
}
