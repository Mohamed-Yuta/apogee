package allali.com.apogee.web;


import allali.com.apogee.entities.*;
import allali.com.apogee.entities.Module;
import allali.com.apogee.repository.*;
import allali.com.apogee.services.EtudiantServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Not;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Controller

public class NoteController {

    private ProfesseurRepository professeurRepository;

    private FillièreRepository fillièreRepository;

    private NoteRepository noteRepository;

    private ModuleRepository moduleRepository;
    private EtudiantRepository etudiantRepository ;
    private AffichageRepository affichageRepository ;

    EtudiantServiceImpl etudiantService;

    @GetMapping("/notes")
    public String notesList(Model model){
        List<Note> list = noteRepository.findAll();
        model.addAttribute("lists",list);
        return "note/notes";
    }
    @GetMapping("/notes/modules")
    public String getModule(){
        return "note/Module";
    }
    @GetMapping("/notes/module")
    public String notesList(Model model, @RequestParam(name = "moduleId", required = false) Long moduleId) {
        List<Note> list;

        if (moduleId != null) {
            // Retrieve notes for the specified module
            Module module = moduleRepository.findById(moduleId).orElse(null);
            list = (module != null) ? noteRepository.findByModuleId(moduleId) : new ArrayList<>();
        } else {
            // If moduleId is not provided, retrieve all notes
            list = noteRepository.findAll();
        }

        model.addAttribute("lists", list);
        return "note/byModule";
    }

    @GetMapping("/addNote")
    public String ajouter() {

        return "note/addNote";
    }
    @PostMapping("/addNote")
    public String ajouterNote(@RequestParam Long etudiantId,
                              @RequestParam Long moduleId,
                              @RequestParam Double valeurNote) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Module module = moduleRepository.findById(moduleId).orElse(null);

        if (etudiant != null && module != null) {
            Note note = new Note();
            note.setEtudiant(etudiant);
            note.setModule(module);
            note.setNoteFinale(valeurNote);
            etudiant.getNotes().add(note);
            module.getNoteList().add(note);
            etudiantRepository.save(etudiant);
            moduleRepository.save(module);

            noteRepository.save(note);
        }


        return "redirect:/notes";
    }
    @GetMapping("/affichage")
    public String affichage(Model model ,@RequestParam Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Affichage affichage=new Affichage() ;
        affichage.setEtudiant(etudiant);
        etudiant.setAffichage(affichage);
        affichage.setSemestre(etudiant.calculerMoyenneSemestre());
        affichageRepository.save(affichage);
        etudiantRepository.save(etudiant);
        model.addAttribute("affichage",affichage);
        return "note/affichage";
    }
    @GetMapping("releves")
    public String relevés(Model model , @RequestParam Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);

        model.addAttribute("lists",etudiant.getNotes());
        model.addAttribute("affichage",etudiant.getAffichage());
        return "note/releves";
    }
    @GetMapping("releve")
    public String getId() {
        return "note/releve";
    }
    @GetMapping("/note/delete")
    public String delete(@RequestParam Long id) {
        noteRepository.deleteById(id);
        return "redirect:/notes";
    }

}


