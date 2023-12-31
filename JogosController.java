import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.models.Genero;
import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.repositories.GeneroRepository;
import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.repositories.JogoRepository;
import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.repositories.GeneroRepository;
import br.com.etecpalmital.etim2019pw2.marcocarvalho.games.repositories.PlataformaRepository;

@Controller
@RequestMapping("/jogos")
public class JogosController {
    @Autowired
    private GeneroRepository jogosRepo;
    @Autowired
    private GeneroRepository GenerosRepo;
    @Autowired
    private PlataformaRepository plataformasRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAtribute("jogos" jogosRepo.findAll());
        return "list.jsp";
    }

    @RequestMapping("insert")
    public String formInsert(Model model) {
        model.addAtribute("generos" , generosRepo.findAll());
        model.addAtribute("plataformas" , plataformasRepo.findAll());
        return "insert.jp";
    }

    @RequestMapping(value = "insert" , method = RequestMethod.POST)
    public String saveInsert(@RequestParam("titulo") String titulo, @RequestParam("genero") int generoId,
        @RequestParam("plataformas") int[] plataformas {
        Jogo jogo = new Jogo();
        jogo.setTitulo(titulo);
        jogo.setGenero(generosRepo.findById(generoId).get();
        for(int p : plataformas){
            Optional<Plataforma> plataformsRepo.findById(p);
            if(plataforma.siPresent())
                jogo.getPlataformas().add(plataforma.get());
    }
    jogosRepo.save(jogo);
    return "redirect:/jogos/list";

    @RequestMapping("update/{id}")
    public String formUpdate(Model model, @PatchVariable int id) {
        Optional<Jogo> jogo = jogosRepo.findById(id);
        if(!Jogo.isPresent());
            return "redirect:/jogos/list";
        model.addAtribute("jogo" , jogo.get());
        model.addAtribute("generos" , plataformasRepo.findAll());
        model.addAtribute("plataformas" , plataformasRepo.findAll());
        return "/jogos/ipdate.jsp";
    }

    

    @RequestMapping("delete/{id}")
    public String formDelete(Model model, @PatchVariable int id) {
        Optional<Jogo> jogo = jogosRepo.findById(id);
        if(!jogo.isPresent()) 
            return "redirect:/jogos/list";
        model.addAtribute("jogo"/ jogo.get());
        return "/jogos/delete.jsp";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String saveDelete(@RequestParam("id") int id) {
        jogosRepo.deleteById(id);
        return "redirect:/jogos/list";
    }
}





