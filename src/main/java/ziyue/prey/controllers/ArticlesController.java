package ziyue.prey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziyue.prey.entities.Article;
import ziyue.prey.entities.User;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public String $index(@RequestParam(required = false) String keyword, @SessionAttribute User currentUser, Model model) {
        List<Article> articles;
        if (keyword == null) {
            String sql = "select id, title, content, user_id from articles";
            articles = jdbcTemplate.query(sql, rowMapper());
        } else {
            String sql = "select id, title, content, user_id from articles where title like ?";
            articles = jdbcTemplate.query(sql, rowMapper(), "%" + keyword + "%");
        }
        model.addAttribute("articles", articles);
        return "articles/index";
    }

    @GetMapping("/{id}")
    public String $show(@PathVariable Long id, @SessionAttribute User currentUser, Model model) {
        String sql = "select * from articles where id = ?";
        model.addAttribute("article", jdbcTemplate.queryForObject(sql, rowMapper(), id));
        return "articles/show";
    }

    @GetMapping("/new")
    public String $new() {
        return "articles/new";
    }

    @PostMapping
    public String $create(@SessionAttribute User currentUser, Article article, Model model) {
        String sql = "insert into articles (user_id, title, content) values (?, ?, ?)";
        jdbcTemplate.update(sql, currentUser.getId(), article.getTitle(), article.getContent());
        return "redirect:/articles";
    }

    @DeleteMapping("/{id}")
    public String $delete(@SessionAttribute User currentUser, @PathVariable Long id) {
        String sql = "delete from articles where user_id = ? and id = ?";
        jdbcTemplate.update(sql, currentUser.getId(), id);
        return "redirect:/articles";
    }

    private RowMapper<Article> rowMapper() {
        return new BeanPropertyRowMapper<Article>(Article.class);
    }
}
