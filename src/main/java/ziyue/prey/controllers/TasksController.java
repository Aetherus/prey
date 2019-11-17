package ziyue.prey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziyue.prey.entities.User;
import ziyue.prey.utils.Task;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public String $index(@RequestParam(required = false) String keyword, @SessionAttribute User currentUser, Model model) {
        String sql = "select * from tasks where user_id = " + currentUser.id;
        if (keyword != null) {
            sql += " where description like '%" + keyword +"%'";
        }
        model.addAttribute("tasks", jdbcTemplate.queryForList(sql, Task.class));
        return "tasks/index";
    }

    @GetMapping("/{id}")
    public String $show(@PathVariable Long id, @SessionAttribute User currentUser, Model model) {
        String sql = "select * from tasks where user_id = ? and id = ?";
        model.addAttribute("task", jdbcTemplate.queryForObject(sql, Task.class, currentUser.id, id));
        return "tasks/show";
    }

    @GetMapping("/new")
    public String $new() {
        return "tasks/new";
    }

    @PostMapping
    public String $create(@SessionAttribute User currentUser, Task task, Model model) {
        String sql = "insert into tasks (user_id, description) values (?, ?)";
        jdbcTemplate.update(sql, currentUser.id, task.description);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String $delete(@SessionAttribute User currentUser, @PathVariable Long id) {
        String sql = "delete from tasks where user_id = ? and id = ?";
        jdbcTemplate.update(sql, currentUser.id, id);
        return "redirect:/tasks";
    }
}
