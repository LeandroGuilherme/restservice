package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestserviceApplication.class, args);
    }
}

class Cidade {

    private long id;
    private String nome;

    private Estado estado;

    public Cidade(long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

@RestController
class CidadeDAO {

    private CidadeDAO cidadeDAO;

    @Autowired
    public CidadeDAO(CidadeDAO cidadeDAO) {
        this.cidadeDAO = cidadeDAO;
    }

    @PostMapping("/cidade")
    public Cidade create(Cidade cidade) throws Exception {
        return null;
    }

    @GetMapping("/cidade")
    public List<Cidade> read() {

        
        Estado sp = new Estado(1, "São Paulo");
        Estado pr = new Estado(2, "Paraná");
        Estado sc = new Estado(3, "Santa Catarina");

        Cidade cidadePR = new Cidade(1, "Praia Grande", sp);
        Cidade cidadeSP = new Cidade(5, "Cornelio Procopio", pr);
        Cidade cidadeSC = new Cidade(10, "Florianópolis", sc);

        ArrayList<Cidade> ListCidade = new ArrayList<>();

        
        ListCidade.add(cidadePR);
        ListCidade.add(cidadeSP);
        ListCidade.add(cidadeSC);

        return ListCidade;
    }

    @PutMapping("/cidade")
    public Cidade update(Cidade cidade) throws Exception {
        return null;
    }

    @DeleteMapping("/cidade/{id}")
    public int delete(Long id) {
        return 200;
    }
}

class Estado {

    private long id;
    private String nome;

    public Estado(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
