package com.mysite.banzzak.notice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Notice> noticeList = this.noticeService.getList();
        model.addAttribute("noticeList", noticeList);
        return "notice/notice_user";
    }
    @GetMapping("/create")
    public String noticeCreate(NoticeForm noticeForm){
        return "notice/notice_form";
    }

    @PostMapping("/create")
    public String noticeCreate(@Valid NoticeForm noticeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "notice/notice_form";
        }
        this.noticeService.create(noticeForm.getNoticeTitle(),noticeForm.getNoticeContent());
        return "redirect:/notice/list";
    }

    @GetMapping("/detail/{noticeId}")
    public String detail(Model model, @PathVariable("noticeId") Integer noticeId){
    Notice notice = (Notice) this.noticeService.getNotice(noticeId);
    model.addAttribute("notice",notice);
        return "notice/notice_detail";
    }
    @PostMapping("/detail/{noticeId}")
    public String edit(@Valid NoticeForm noticeForm, BindingResult bindingResult,
                       Principal principal, @PathVariable("noticeId") Integer noticeId){
        if (bindingResult.hasErrors()) {
            return "notice/notice_detail"; // 오류가 있을 경우 수정 화면으로 돌아감
        }
        Notice notice = this.noticeService.getNotice(noticeId);
        this.noticeService.edit(notice, noticeForm.getNoticeTitle(), noticeForm.getNoticeContent());
        return String.format("redirect:/notice/detail/%d",noticeId);
    }
}
