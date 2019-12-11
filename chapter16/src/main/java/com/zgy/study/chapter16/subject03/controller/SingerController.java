package com.zgy.study.chapter16.subject03.controller;

import com.zgy.study.chapter16.subject03.entity.Singer;
import com.zgy.study.chapter16.subject03.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ZGY
 * @date 2019/12/11 16:08
 * @description SingerController
 */
@Controller
@RequestMapping("/singers")
public class SingerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerController.class);

    @Autowired
    private SingerService singerService;

    @RequestMapping(method = RequestMethod.GET)
    public String List(Model model) {
        LOGGER.info("==================> 调用 public String List(Model model) 开始");
        List<Singer> singerList = singerService.findAll();
        model.addAttribute("singerList", singerList);
        return "singers/list";
    }
}
