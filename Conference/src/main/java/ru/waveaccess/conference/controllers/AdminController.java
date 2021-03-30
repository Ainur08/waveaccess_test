package ru.waveaccess.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.waveaccess.conference.services.AdminService;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String getUsers(Model model) {
        model.addAttribute("users", adminService.findAllUser());
        return "admin";
    }

    @PostMapping("/admin/role/{id}")
    public String makePresenter(@PathVariable Long id) {
        adminService.makePresenter(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String email) {
        adminService.updateNameAndEmail(id, name, email);
        return "redirect:/admin";
    }
}
