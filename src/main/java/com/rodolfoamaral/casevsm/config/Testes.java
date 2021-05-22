package com.rodolfoamaral.casevsm.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodolfoamaral.casevsm.entidades.Cliente;
import com.rodolfoamaral.casevsm.entidades.Cidades;
import com.rodolfoamaral.casevsm.entidades.enums.EnumStatus;
import com.rodolfoamaral.casevsm.repositories.ClienteRepositorio;
import com.rodolfoamaral.casevsm.repositories.CidadesRepositorio;

@Configuration
@Profile("test")
public class Testes implements CommandLineRunner {
	
	@Autowired
	private ClienteRepositorio repoCliente;
	
	@Autowired
	private CidadesRepositorio repoEst;
	
	
	@Override
	public void run(String... args) throws Exception {		
	Cliente cli1 = new Cliente(null, "Rodolfo Amaral", "12345678910", "Masculino", "Assis", "SP", "Av. Dom Antonio", 1505, "Vila Tênis Clube", "19806173", "3º Andar", "183402-0000", "rodolfocornieri@gmail.com", "Casado", LocalDateTime.now(), EnumStatus.ATIVO);
	Cliente cli2 = new Cliente(null, "Camila Alves", "10987654321", "Feminino", "Assis", "SP", "R. Filomena C. Longo", 36, "San Fernando Valley", "19800425", "CASA", "18996362736", "avles.camila456@gmail.com", "Casada", LocalDateTime.now(), EnumStatus.ATIVO);
	repoCliente.saveAll(Arrays.asList(cli1, cli2));
	
	Cidades cid1 = new Cidades(null, "Assis", "SP");
	Cidades cid2 = new Cidades(null, "Adamantina", "São Paulo");
	repoEst.saveAll(Arrays.asList(cid1, cid2));	
	}
}
