package com.appStore.controller;

import com.appStore.model.AppMessage;
import com.appStore.model.Categories;
import com.appStore.service.ICategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/category")

public class CategoryController {
    @Resource
    private ICategoryService categoryService;

    @RequestMapping("/list/{page}/{offset}")
    public void getList(HttpServletRequest request, HttpServletResponse response, @PathVariable("page") String page, @PathVariable("offset") String offset) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int _start = Integer.parseInt(page);
        int _offset = Integer.parseInt(offset);
        _start = _start * _offset;
        ArrayList<Categories> categoryList = this.categoryService.getCategoryList(_start, _offset);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(categoryList));
        response.getWriter().close();
    }

    @RequestMapping("/apps/{id}/{page}/{offset}")
    public void getCategoryById(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id, @PathVariable("page") String page, @PathVariable("offset") String offset) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int _id = Integer.parseInt(id);
        int _page = Integer.parseInt(page);
        int _offset = Integer.parseInt(offset);
        ArrayList<AppMessage> appMessages = this.
                categoryService.getAppMessageByCId(_page * _offset, _offset, _id);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(appMessages));
        response.getWriter().close();
    }
}
