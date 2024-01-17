package allali.com.apogee.web;

import allali.com.apogee.entities.Etudiant;
import allali.com.apogee.entities.Module;
import allali.com.apogee.entities.Note;
import allali.com.apogee.repository.EtudiantRepository;
import allali.com.apogee.repository.ModuleRepository;
import allali.com.apogee.repository.ProfesseurRepository;
import allali.com.apogee.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class EtudiantRestController {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private EtudiantServiceImpl etudiantService ;

    @GetMapping("/etudiants")
    public String etudiantList(Model model){
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        model.addAttribute("lists",etudiantList);
        return "etudiants";
    }
    @GetMapping("/index")
    public String index(){
        return "home";
    }

    @GetMapping("/etudiant")
    public String etudiant(Model model){
        model.addAttribute("etudiant", new Etudiant()); // Initialize etudiant object
        return "formEtudiant";

    }
    @PostMapping("/etudiant")
    public String save(Model model,
                       Etudiant etudiant,
                       BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page) {
        if(bindingResult.hasErrors()) return "formEtudiant";
        etudiantRepository.save(etudiant);
        return "redirect:/etudiants?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/etudiant/delete")
    public String delete(@RequestParam Long id) {
        etudiantRepository.deleteById(id);
        return "redirect:/etudiants";
    }
    @GetMapping("/etudiant/editEtudiant")
    public String editEtudiant(Model model, Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("etudiant introuvable !");
        model.addAttribute("etudiant",etudiant);
        return "editEtudiant";
    }
    @GetMapping("/etudiant/{id}/moyenneSemestre")
    public Double calculerMoyenneSemestre(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.rechercher(id);
        return etudiant.calculerMoyenneSemestre();
    }


}
