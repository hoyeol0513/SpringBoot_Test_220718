package com.mysite.sbb_test.Reply;

import com.mysite.sbb_test.Article.Article;
import com.mysite.sbb_test.Article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private final ReplyService replyService;
    private final ArticleService articleService;

    @PostMapping("/create/{id}")
    public String createReply(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Article article = this.articleService.getArticle(id);
        this.replyService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}
