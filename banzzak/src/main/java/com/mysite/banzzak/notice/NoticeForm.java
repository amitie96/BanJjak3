package com.mysite.banzzak.notice;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeForm {

    @Size(max= 200)
    @NotEmpty(message="제목은 필수 항목입니다.")
    private String noticeTitle;

    @NotEmpty(message="내용은 필수 항목입니다.")
    private String noticeContent;

}
