
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColum
import javax.persistence.JoinTable
import javax.persistence.ManyToMany


import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @ManyToOne
    @JoinColum(name='id_genero')
    private Genero genero;

    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColum(name = "jogos_id"),
        inverseJoinColumns = @JoinColum(name = "plataforma_id"))
    private Set<Plataforma> plataformas = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setGenero(Genero genero) {
        return this.genero;
    }
    public Genero getGenero(){
        return this.genero;
    }

    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
    public Set<Plataforma> getPlataformas() {
        return this.plataformas;
    }
}

