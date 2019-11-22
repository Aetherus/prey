package ziyue.prey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ziyue.prey.annotations.SkipAuthentication;

@Controller
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/new")
    @SkipAuthentication
    public String $new() {
        return "registrations/new";
    }

    @PostMapping
    @SkipAuthentication
    public String $create(@RequestParam String username, @RequestParam String password) {
        try {
            String sql = "insert into users (username, password) values (?, ?)";
            jdbcTemplate.update(sql, username, password);
            return "redirect:/sessions/new#registration-success";
        } catch (Exception e) {
            return "redirect:/registrations/new#duplicate-username";
        }

    }
}
