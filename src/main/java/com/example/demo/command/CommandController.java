package com.example.demo.command;

import com.example.demo.medcin.MedcinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CommandController {

    @Autowired
    private CommandService commandService;

    @Autowired
    private MedcinService medcinService;


    //display all commands
    @GetMapping("/commands")
    public String commandViewPage(Model model){
        model.addAttribute("listCommands", commandService.getAllCommands());
        return "commands";
    }

    @GetMapping("/addCommandForm")
    public String addCommandForm(Model model){
        //create model attribute to bind form data
        command command = new command();
        model.addAttribute("command", command);
        model.addAttribute("listMedcins", medcinService.getAllMedcins());
        return "addCommandForm";
    }
    
    @PostMapping("/saveCommand")
    public String saveCommand(@ModelAttribute("command") command command){
        //save command to db
        commandService.saveCommand(command);
        return "redirect:/commands";
    }

    @GetMapping("/updateCommandForm/{id}")
    public String updateCommandForm(@PathVariable("id") long id, Model model){
        //get command from db
        command command = commandService.getCommandById(id);
        //set command as a model attribute to pre-populate the form
        model.addAttribute("command", command);
        model.addAttribute("listMedcins", medcinService.getAllMedcins());
        return "updateCommandForm";
    }

    @GetMapping("/deleteCommand/{id}")
    public String deleteCommand(@PathVariable("id") long id){
        //call delete command method
        this.commandService.deleteCommandById(id);
        return "redirect:/commands";
    }

    @GetMapping("/")
    public String Dashboard(){
        return "Dashboard";
    }
}
