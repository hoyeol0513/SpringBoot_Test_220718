package com.mysite.sbb_test.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getList() {
        List<Article> lists = articleRepository.findAll();
        return lists;
    }
}
