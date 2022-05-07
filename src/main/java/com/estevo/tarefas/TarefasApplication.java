package com.estevo.tarefas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.estevo.tarefas.domain.Categoria;
import com.estevo.tarefas.domain.Tarefa;
import com.estevo.tarefas.repositories.CategoriaRepository;
import com.estevo.tarefas.repositories.TarefaRepository;

@SpringBootApplication
public class TarefasApplication implements CommandLineRunner{


	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
				
		// criação categoria1
		Categoria cat1 = new Categoria(null, "Pessoal", "Tarefas pessoais");
		
		
		//criação tarefa1
		Tarefa t1 = new Tarefa(null, "Fazer faxina", "Faxinar o quarto e a sala",
				"Jefferson", "Alta", "06-05-2022", cat1);
		
		// criando conexão entre categoria1 e tarefa1
		cat1.getTarefas().addAll(Arrays.asList(t1));
		
		// salvando dados na base de dados
		//this.categoriaRepository.saveAll(Arrays.asList(cat1));
		//this.tarefaRepository.saveAll.(Arrays.asList(t1));
		
	}

}
