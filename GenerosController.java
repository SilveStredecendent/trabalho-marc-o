import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Optional;

import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.models.Genero;
import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.repositories.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GenerosController {
    @Autowired
    private GeneroRepository generosRepo;
    @RequestMapping("list")
    public String list(Model model) {
        model.addAtribute("generos", generosRepo.findAll());
        return "list.jsp";
    }

    @RequestMapping("insert")
    public String formInsert() {
        return "insert.jsp";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        generosRepo.save(genero);
        return "redirect:/generos/list";
    }

    @RequestMapping("update/{id}")
    public String formUpdate(Model model, @PatchVariable int id) {
        Optional<Genero> genero = generosRepo.findById(id)
        if(!genero.isPresent())
            return "redirect:/generos/list";
        model.addAtribute("genero", genero.get());
        return "/generos/update.jsp";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Genero> genero = generosRepo.findById(id);
        Genero genero = new Genero();
        if(!genero.isPresent())
            return "redirect:/generos/list";
        genero.get().setNome(nome);
        generosRepo.save(genero.get());
        return "redirect:/generos/list";
    }

    @RequestMapping("delete/{id}")
    public String formDelete(Model model, @PatchVariable int id) {
        Optional<Genero> genero = generosRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/generos/list";
        model.addAtribute("genero", genero.get());
        return "/generos/delete/jsp";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String saveDelete(@RequestParam("id") int id) {
        Genero genero = new Genero();
        generosRepo.deleteById(id);
        return "redirect:/generos/list";
    }

}
