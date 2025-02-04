package dom.jp.GestionTareas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import dom.jp.GestionTareas.models.Tarea;
import dom.jp.GestionTareas.services.TareaServiceImpl;
import jakarta.validation.Valid;



@Controller
public class TareaController {

//Implementar las operaciones básicas:
// Crear una tarea.
// Leer todas las tareas.
// Actualizar una tarea.
// Eliminar una tarea.

    @Autowired
    TareaServiceImpl repo;

    @GetMapping({"/","#","index"})
    public String incio(Model model) {
        
        Tarea nuevaTarea = new Tarea();
        model.addAttribute("nuevaTarea", nuevaTarea);

        List<Tarea> listaTareas = repo.buscarTodasLasTareas();
        model.addAttribute("listaTareas", listaTareas);

        return "index";
    }
    

    @PostMapping("/tarea/crear")
    public String crearTarea(@Valid @ModelAttribute("nuevaTarea") Tarea unaTarea, 
                            BindingResult result, 
                            Model model) {
        if (result.hasErrors()) {
             List<Tarea> listaTareas = repo.buscarTodasLasTareas();
             model.addAttribute("listaTareas", listaTareas);
            return "index";
        }
        repo.guardarTarea(unaTarea);
        return "redirect:/";
    }

    @GetMapping("/tarea/eliminar/{id}")
    public String eliminarTarea(@PathVariable int id) {
        repo.eliminarTarea(id);
        return "redirect:/";
    }
    
    

    @GetMapping("/tarea/editar/{id}")
    public String editarTareaView(@PathVariable int id, Model model) {
        Tarea tarea = repo.buscarTareaPorId(id);
        model.addAttribute("tarea", tarea);
        return "editarTarea";
    }

 
@PostMapping("/tarea/editar")
public String editarTarea(@Valid @ModelAttribute("tarea") Tarea tarea,
                         BindingResult result, 
                         Model model) {

    if(result.hasErrors()){
        model.addAttribute("tarea", tarea);
        return "editarTarea";
    }

    repo.editarTarea(tarea);
    return "redirect:/";
}


}
