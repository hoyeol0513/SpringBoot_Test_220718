package com.mysite.sbb_test.Article;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public String showList(Model model){
        List<Article> articlelist = articleService.getList();
        model.addAttribute("articlelist", articlelist);
        return "article_list";
    }

}
