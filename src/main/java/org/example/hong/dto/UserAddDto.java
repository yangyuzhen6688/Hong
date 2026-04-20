package org.example.hong.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserAddDto {
    @NotBlank(message = "用户名不能为空或仅含空格")
    private String userName;
    @NotBlank(message = "密码不能为空或仅含空格")
    private String password;
    @NotBlank(message = "email不能为空或仅含空格")
    private String email;
    @NotBlank(message = "电话不能为空或仅含空格")
    private String phone;
    @NotBlank(message = "地址不能为空或仅含空格")
    private String address;
}
