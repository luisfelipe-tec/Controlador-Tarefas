package com.example.demo.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "task-list";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        task.setId(tasks.size() + 1L);
        task.setDataDeCriacao(LocalDate.now());
        tasks.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        Task task = findTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "task-details";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Task task = findTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "task-form";
        }
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute Task updatedTask) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitulo(updatedTask.getTitulo());
            task.setDescricao(updatedTask.getDescricao());
        }
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable("id") Long id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
        }
        return "redirect:/tasks";
    }

    private Task findTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
