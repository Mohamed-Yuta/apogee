package allali.com.apogee.web;


import allali.com.apogee.entities.Etudiant;
import allali.com.apogee.entities.Fillière;
import allali.com.apogee.entities.Module;
import allali.com.apogee.entities.Professeur;
import allali.com.apogee.repository.*;
import allali.com.apogee.services.EtudiantServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@AllArgsConstructor
@Controller
public class ModuleController {

    private ProfesseurRepository professeurRepository;

    private FillièreRepository fillièreRepository;

    private NoteRepository noteRepository;

    private ModuleRepository moduleRepository;
    private EtudiantRepository etudiantRepository ;

    EtudiantServiceImpl etudiantService;

    @GetMapping("/modules")
    public String modulesList(Model model) {
        List<Module> modulesList = moduleRepository.findAll();
        model.addAttribute("lists", modulesList);
        return "modules/modules";
    }


    @GetMapping("/module")
    public String module(Model model) {
        model.addAttribute("module", new Module()); // Initialize etudiant object
        return "modules/formModule";
    }
    @PostMapping("/module")
    public String save(Model model,
                       Module module,
                       BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam String nomFilliere,  // Nouveau paramètre pour le nom de la filière
                       @RequestParam String nomProfesseur) {  // Nouveau paramètre pour le nom du professeur
        if (bindingResult.hasErrors()) return "modules/formModule";

        // Recherchez la filière par nom
        Fillière filliere = fillièreRepository.findByNom(nomFilliere);
        if (filliere == null) {
            // Gérez le cas où la filière n'est pas trouvée
        }
        module.setFilliere(filliere);

        // Recherchez le professeur par nom
        Professeur professeur = professeurRepository.findByNom(nomProfesseur);
        if (professeur == null) {
            // Gérez le cas où le professeur n'est pas trouvé
        }
        module.setProfesseur(professeur);

        moduleRepository.save(module);
        return "redirect:/modules?page=" + page + "&keyword=" + keyword;
    }
    @GetMapping("/moduleList")
    public String moduleList(Model model) {
        //model.addAttribute("module", new Module()); // Initialize etudiant object
        return "modules/formModuleList";

    }
    @PostMapping("/moduleList")
    public String save(
                       @RequestParam String moduleNom,

                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam String nomEtudiant ){

        // Recherchez la filière par nom
        Etudiant etudiant = etudiantRepository.findByNom(nomEtudiant);
        if (etudiant == null) {
            // Gérez le cas où la filière n'est pas trouvée
        }
        Module module = moduleRepository.findByNom(moduleNom);
        module.getEtudiantList().add(etudiant);
        etudiant.getModuleList().add(module);
        // Recherchez le professeur par nom


        moduleRepository.save(module);
        etudiantRepository.save(etudiant);

        return "redirect:/modules?page=" + page + "&keyword=" + keyword;
    }
    @GetMapping("/admin")
    public String list(Model model){

        Etudiant etudiant = etudiantRepository.findById(3L).orElse(null);
        model.addAttribute("list",etudiant.getModuleList());
        return "admin";

    }


    @GetMapping("/module/delete")
    public String delete(@RequestParam Long id) {
        moduleRepository.deleteById(id);
        return "redirect:/modules";
    }

    @GetMapping("/module/editModule")
    public String editModule(Model model, Long id) {
        Module module = moduleRepository.findById(id).orElse(null);
        if (module == null) throw new RuntimeException("etudiant introuvable !");
        model.addAttribute("module", module);
        return "modules/editModule";
    }
}


