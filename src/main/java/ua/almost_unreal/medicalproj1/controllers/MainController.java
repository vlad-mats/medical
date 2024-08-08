package ua.almost_unreal.medicalproj1.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.almost_unreal.medicalproj1.dao.PatientDao;
import ua.almost_unreal.medicalproj1.entity.Patient;

@Controller
public class MainController {

    private boolean acces=false;
    private String password="2233";
    private String dir ="/html/main/";
    private final PatientDao patientDao;

    public MainController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
    private boolean checkUat(HttpSession session){
        boolean acc=session.getAttribute("acces")!=null;
        return acc;
    }

    @GetMapping("/")
    public String mainPage(Model model, HttpSession session) {
        if(!checkUat(session)) {
            return "redirect:/login";
        }else{
            model.addAttribute("patients",patientDao.findAllUsers() );
            return dir+"main";
        }
    }
    @GetMapping("/login")
    public String login() {
        return dir+"login";
    }
    @PostMapping("/login")
    public String loginPost(@RequestParam String password, Model model, HttpSession session) {
        if(password.equals(this.password)){
           session.setAttribute("acces",true);
            return "redirect:/";
        }else{
            model.addAttribute("mess","incorrect password");
            return dir+"login";
        }

    }

    @GetMapping("/addPatient")
    public String addPatient(Model model, HttpSession session) {
        if(!checkUat(session)) {
            return "redirect:/login";
        }
        model.addAttribute("patient", new Patient());
        return dir+"addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatientPost(@ModelAttribute Patient patient, Model model) {
        patientDao.save(patient);
        return "redirect:/";
    }
    @GetMapping("/updatePatient/{id}")
    public String updatePatient(@PathVariable long id, Model model, HttpSession session) {
        if(!checkUat(session)) {
            return "redirect:/login";
        }
        model.addAttribute("patient", patientDao.findById(id));
        return dir+"updatePatient";
    }
    @PostMapping("/updatePatient")
    public String updatePatientPost(@ModelAttribute Patient patient,Model model) {
        patientDao.save(patient);
        return "redirect:/";
    }
    @PostMapping("/deletePatient")
    public String deletePatient(@RequestParam long id,Model model) {
        patientDao.removeUser(patientDao.findById(id));
        return "redirect:/";
    }


}
