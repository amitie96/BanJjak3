package com.mysite.banzzak.notice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    @Column(length = 200)
    private String noticeTitle;

    @Column(columnDefinition = "TEXT")
    private String noticeContent;

    private LocalDateTime noticeDate;

}
