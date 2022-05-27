package com.example.demo.medcin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
//@RequestMapping(path="api/v1/command")
public class MedcinController {
   
    @Autowired
    private MedcinService medcinService;

    // @Autowired
    // public CommandController(CommandService commandService) {
    //     this.commandService = commandService;
    // }
    
    //display all medcins
    @GetMapping("/medcins")
    public String medcinViewPage(Model model){
        model.addAttribute("listMedcins", medcinService.getAllMedcins());
        return "medcins";
        }
    
    @GetMapping("/addMedcinForm")
    public String addMedcinForm(Model model){
        //create model attribute to bind form data
        medcin medcin = new medcin();
        model.addAttribute("medcin", medcin);
        return "addMedcinForm";
    }

    @PostMapping("/saveMedcin")
    public String savemedcin(@ModelAttribute("medcin") medcin medcin){
        //save medcin to db
        medcinService.saveMedcin(medcin);
        return "redirect:/medcins";
    }

    @GetMapping("/updateMedcinForm/{id}")
    public String updateMedcinForm(@PathVariable("id") long id, Model model){
        //get medcin from db
        medcin medcin = medcinService.getMedcinById(id);
        //set medcin as a model attribute to pre-populate the form
        model.addAttribute("medcin", medcin);
        return "updateMedcinForm";
    }

    @GetMapping("/deleteMedcin/{id}")
    public String deleteMedcin(@PathVariable("id") long id){
        //call delete medcin method
        this.medcinService.deleteMedcinById(id);
        return "redirect:/medcins";
    }

   
}
    
