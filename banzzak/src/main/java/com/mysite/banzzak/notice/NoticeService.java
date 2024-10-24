package com.mysite.banzzak.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private  final NoticeRepository noticeRepository;

    public List<Notice> getList() {
        return this.noticeRepository.findAll();
    }

    public void create(String Noticetitle, String Noticecontent) {
        Notice n = new Notice();
        n.setNoticeTitle(Noticetitle);
        n.setNoticeContent(Noticecontent);
        n.setNoticeDate(LocalDateTime.now());
        this.noticeRepository.save(n);
    }
}
