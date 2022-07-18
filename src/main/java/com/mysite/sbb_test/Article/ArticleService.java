package com.mysite.sbb_test.Article;

import com.mysite.sbb_test.Util.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {
    @Autowired
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        }else{
            throw new DataNotFoundException("article not found");
        }
    }

    public String setItemView(Integer id){
        Article article = articleRepository.findById(id).get();
        article.setView(article.getView()+1);
        articleRepository.save(article);
        return "조회수가 증가되었습니다.";
    }
}
