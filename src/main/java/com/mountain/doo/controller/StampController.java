package com.mountain.doo.controller;

import com.mountain.doo.dto.AccountResponseDTO;
import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.entity.Stamp;
import com.mountain.doo.service.StampService;
import com.mountain.doo.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
@Slf4j
public class StampController {

    private final StampService stampService;

    // 내 스탬프 보기
    @GetMapping("/stamp")
    public String myStampPage(Model model, HttpSession session){

        AccountResponseDTO loginUserData = (AccountResponseDTO) session.getAttribute(LoginUtil.LOGIN_KEY);

        String accountId=loginUserData.getAccountId();

        log.info("Get Stamp 요청 accountId: "+accountId);

        Stamp stamp = stampService.stampCount(accountId);

        log.info("스탬프 : "+stamp.getAccountId());
        System.out.println("스탬프 : "+stamp);
        model.addAttribute("stamp",stamp);

//        stampService.loginStamp(StampAddConditionDTO,accountId);

/*
        dto.setAccountId(loginUserData.getAccountId());

        //id가 가지고 있는 총 스탬프 수
        Stamp stampCount = stampService.stampCount(dto);
        stampService.boardBanner(dto);

        StampAddConditionDTO dto;
        model.addAttribute("sc",dto);*/
        return "/event/stamp";

    }




}
