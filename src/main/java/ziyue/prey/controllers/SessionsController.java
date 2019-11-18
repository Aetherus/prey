package ziyue.prey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ziyue.prey.annotations.SkipAuthentication;
import ziyue.prey.entities.User;
import ziyue.prey.utils.DigestUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sessions")
public class SessionsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/new")
    @SkipAuthentication
    public String $new(){
        return "sessions/new";
    }

    @PostMapping
    @SkipAuthentication
    public String $create(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = jdbcTemplate.queryForObject(
                "select * from users where username = ?",
                new BeanPropertyRowMapper<User>(User.class),
                username);
        if (user == null) {
            return "redirect:/sessions/new#invalid-username";
        }
        String passwordDigest = DigestUtil.digest(password);
        if (!user.getPasswordDigest().equals(passwordDigest)) {
            return "redirect:/sessions/new#invalid-password";
        }
        session.setAttribute("currentUser", user);
        return "redirect:/articles";
    }

}
