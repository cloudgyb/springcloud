package com.gyb.microservice.service.user.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserVO {
    private String id;
    private String name;
    private int age;
    private String sex;
}
