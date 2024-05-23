package com.aug.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aug.helpdesk.domain.Chamado;
import com.aug.helpdesk.domain.Cliente;
import com.aug.helpdesk.domain.Tecnico;
import com.aug.helpdesk.domain.enums.Perfil;
import com.aug.helpdesk.domain.enums.Prioridade;
import com.aug.helpdesk.domain.enums.Status;
import com.aug.helpdesk.repositories.ChamadoRepository;
import com.aug.helpdesk.repositories.ClienteRepository;
import com.aug.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec0 = new Tecnico(null, "Osandi A S Mariano", "12244046028", "amariano@gmail.com", "123456");
		Tecnico tec1 = new Tecnico(null, "Jane Soares Maia", "05246907074", "janes.maia@gmail.com", "123456");
		Tecnico tec2 = new Tecnico(null, "Deborah Soares Maia", "11222934027", "deborah.maia@gmail.com", "123456");
		Tecnico tec3 = new Tecnico(null, "Maria Augusta S. Neta", "58750898060", "maugustaneta@gmail.com", "123456");

		tec0.addPerfis(Perfil.ADMIN);
		tec1.addPerfis(Perfil.TECNICO);
		tec2.addPerfis(Perfil.TECNICO);
		tec3.addPerfis(Perfil.TECNICO);

		tecnicoRepository.saveAll(Arrays.asList(tec0, tec1, tec2, tec3));
		
		Cliente cli1 = new Cliente(null, "Josefina Alves", "86313217020", "josefaalves@gmail.com", "123456");
		Cliente cli2 = new Cliente(null, "Alana de Barros Alves", "28768581009", "alanabalves@gmail.com", "123456");
		Cliente cli3 = new Cliente(null, "Barrerito de Paula", "49488457015", "barreritodp@gmail.com", "123456");
		Cliente cli4 = new Cliente(null, "João Mineiro", "38408231022", "joaomineiro@gmail.com", "123456");

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));		

		Chamado ch1 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Erro em instalação de Software", "Já reinstalei a aplicação", tec3, cli4);

		chamadoRepository.saveAll(Arrays.asList(ch1));

	}

}
