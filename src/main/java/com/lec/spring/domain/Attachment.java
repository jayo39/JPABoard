package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "t7_attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(nullable = false)
    private String sourcename; // 원본파일 이름

    @Column(nullable = false)
    private String filename; // 저장된 파일명 (rename 된 파일명)

    @Column(name = "post_id")
    private Long post; // 어느글의 첨부파일? (FK)

    @Transient
    private boolean isImage; // 이미지 여부
}
