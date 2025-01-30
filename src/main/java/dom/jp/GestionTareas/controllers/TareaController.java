package dom.jp.GestionTareas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dom.jp.GestionTareas.models.Tarea;
import dom.jp.GestionTareas.services.TareaServiceImpl;



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
    

    @PostMapping("tarea/crear")
    public String crearTarea(@ModelAttribute Tarea unaTarea) {
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

 // filepath: /C:/Users/juanp/OneDrive/Documentos/Gestion-de-Tareas/src/main/java/dom/jp/GestionTareas/controllers/TareaController.java
@PostMapping("/tarea/editar")
public String editarTarea(@ModelAttribute Tarea tarea) {
    System.out.println("-------**********-------- ID de la tarea a editar: " + tarea.getId());
    repo.editarTarea(tarea);
    return "redirect:/";
}


}
