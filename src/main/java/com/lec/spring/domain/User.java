package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t7_user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(unique = true, nullable = false)
    private String username; // 회원 아이디

    @Column(nullable = false)
    @JsonIgnore
    private String password; // 회원 비밀번호

    @Transient // DB 에 반영 안함 jakarta.persistence
    @ToString.Exclude // Lombok 의 ToString 에서 제외할 필드
    @JsonIgnore
    private String re_password; // 비밀번호 확인 입력

    @Column(nullable = false)
    private String name; // 회원 이름

    // User:Authority = N:M

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    @JsonIgnore
    private List<Authority> authorities = new ArrayList<>();

    public void addAuthority(Authority... authorities) {
        if(authorities != null) {
            Collections.addAll(this.authorities, authorities);
        }
    }
}
