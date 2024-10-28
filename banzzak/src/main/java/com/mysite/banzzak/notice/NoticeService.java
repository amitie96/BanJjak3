package com.mysite.banzzak.notice;

import com.mysite.banzzak.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private  final NoticeRepository noticeRepository;

    public List<Notice> getList() {
        return this.noticeRepository.findAll();
    }

  public void create(String noticeTitle, String noticeContent) {
        Notice n = new Notice();
        n.setNoticeTitle(noticeTitle);
        n.setNoticeContent(noticeContent);
        n.setNoticeDate(LocalDateTime.now());
        this.noticeRepository.save(n);
    }
    public Notice getNotice(Integer noticeId){
        Optional<Notice> notice = this.noticeRepository.findById(noticeId);
        if(notice.isPresent()){
            return notice.get();
        }else{
            throw new DataNotFoundException("notice not found");
        }
    }
    public void edit(Notice notice, String noticeTitle, String noticeContent){
        notice.setNoticeTitle(noticeTitle);
        notice.setNoticeContent(noticeContent);
        this.noticeRepository.save(notice);

    }

}
