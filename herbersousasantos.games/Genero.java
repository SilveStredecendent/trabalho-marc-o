
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.OneToMany;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="generos")
public class Genero {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "genero")
    private Set<Jogo> jogos = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
    public void setJogos(Set<Jogo> jogos) {
        this.jogos = jogos;
    }
    public Set<jogo> getJogos() {
        return this.jogos;
    }
}



