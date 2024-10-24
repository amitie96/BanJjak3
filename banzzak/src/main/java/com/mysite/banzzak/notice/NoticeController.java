package com.mysite.banzzak.notice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
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
}
