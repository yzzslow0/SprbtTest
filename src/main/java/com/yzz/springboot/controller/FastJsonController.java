package com.yzz.springboot.controller;


import com.yzz.springboot.bean.TList;
import com.yzz.springboot.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yzz
 */
@Controller
@RequestMapping("fastjson")
public class FastJsonController {


    private final ListRepository listRepository;

    @Autowired
    public FastJsonController(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<TList> test() {

        return listRepository.findAll();
    }


    /**
     * @param pageNum  当前页
     * @param pageSize 当前页面展示数目
     */
    @RequestMapping("/testPage")
    @ResponseBody
    public Page<TList> getList(int pageNum, int pageSize) {

        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return listRepository.findAll(pageable);

    }
}