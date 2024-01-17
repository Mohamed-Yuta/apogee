package allali.com.apogee.web;


import allali.com.apogee.DTOs.NoteDTO;
import allali.com.apogee.entities.Etudiant;
import allali.com.apogee.entities.Module;
import allali.com.apogee.entities.Note;
import allali.com.apogee.entities.Professeur;
import allali.com.apogee.repository.FillièreRepository;
import allali.com.apogee.repository.ModuleRepository;
import allali.com.apogee.repository.NoteRepository;
import allali.com.apogee.repository.ProfesseurRepository;
import allali.com.apogee.services.EtudiantServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller

@AllArgsConstructor
@Slf4j
public class ProfesseurRestController {

    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private FillièreRepository fillièreRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    EtudiantServiceImpl etudiantService;

    @GetMapping("/professeurs")
    public String professeursList(Model model) {
        List<Professeur> professeursList = professeurRepository.findAll();
        model.addAttribute("lists", professeursList);
        return "professeurs/professeurs";
    }


    @GetMapping("/professeur")
    public String professeur(Model model) {
        model.addAttribute("professeur", new Professeur()); // Initialize etudiant object
        return "professeurs/formProfesseur";

    }

    @PostMapping("/professeur")
    public String save(Model model,
                       Professeur professeur,
                       BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page) {
        if (bindingResult.hasErrors()) return "professeurs/formProfesseur";
        professeurRepository.save(professeur);
        return "redirect:/professeurs?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/professeur/delete")
    public String delete(@RequestParam Long id) {
        professeurRepository.deleteById(id);
        return "redirect:/professeurs";
    }

    @GetMapping("/professeur/editProfesseur")
    public String editProfesseur(Model model, Long id) {
        Professeur professeur = professeurRepository.findById(id).orElse(null);
        if (professeur == null) throw new RuntimeException("etudiant introuvable !");
        model.addAttribute("professeur", professeur);
        return "professeurs/editProfesseur";
    }
}



    /*@GetMapping("/modules/{id}")
    public List<Module> getModuleByFilliere(@PathVariable long id){
        List<Module> listModules = fillièreRepository.findModuleListById(id);
        return listModules ;
    }
    @GetMapping("profnotes/{id}")
    public List<Note> getNotesByProfesseur(@PathVariable Long id) {
        List<Note> noteList = noteRepository.findByProfesseurId(id);
        return noteList ;
    }
    @GetMapping("etudiantnotes/{id}")
    public List<Note> getNotesByEtudiant(@PathVariable Long id) {
        List<Note> noteList = noteRepository.findByEtudiantId(id);
        return noteList ;
    }

    @GetMapping("moduleNotes/{id}")
    public List<NoteDTO> getNotesByModule(@PathVariable Long id) {
        List<Note> noteList = noteRepository.findByModuleId(id);
        return noteList.stream().map(NoteDTO::from).collect(Collectors.toList());
    }

}
*/