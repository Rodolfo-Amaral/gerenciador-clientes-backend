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
	
	Cidades cid1 = new Cidades(null, "Assis", "São Paulo", "SP");
	Cidades cid2 = new Cidades(null, "Adamantina", "São Paulo", "SP");
	Cidades cid3 = new Cidades(null, "Cândido Mota", "São Paulo", "SP");
	Cidades cid4 = new Cidades(null, "Marília", "São Paulo", "SP");
	Cidades cid5 = new Cidades(null, "São Paulo", "São Paulo", "SP");
	Cidades cid6 = new Cidades(null, "Barra Bonita", "São Paulo", "SP");
	Cidades cid7 = new Cidades(null, "Niterói", "Rio de Janeiro", "RJ");
	Cidades cid8 = new Cidades(null, "Rio de Janeiro", "Rio de Janeiro", "RJ");
	Cidades cid9 = new Cidades(null, "Feira de Santana", "Bahia", "BA");
	Cidades cid10 = new Cidades(null, "Belo Horizonte", "Minas Gerais", "MG");
	Cidades cid11 = new Cidades(null, "Maringá", "Paraná", "PR");
	Cidades cid12 = new Cidades(null, "Rio Branco", "Acre", "AC");
	Cidades cid13 = new Cidades(null, "Navegantes", "Santa Catarina", "SC");
	Cidades cid14 = new Cidades(null, "Brusque", "Santa Catarina", "SC");
	Cidades cid15 = new Cidades(null, "Blumenau", "Santa Catarina", "SC");
	Cidades cid16 = new Cidades(null, "Itajaí", "Santa Catarina", "SC");
	Cidades cid17 = new Cidades(null, "Porto Alegre", "Rio Grande do Sul", "RS");
	Cidades cid18 = new Cidades(null, "Vitória", "Espírito Santo", "ES");
	Cidades cid19 = new Cidades(null, "Palmas", "Tocantins", "TO");
	Cidades cid20 = new Cidades(null, "Manaus", "Amazonas", "AM");
	Cidades cid21 = new Cidades(null, "Natal", "Rio Grande do Norte", "RN");
	Cidades cid22 = new Cidades(null, "Cuiabá", "Mato Grosso", "MT");
	repoEst.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6, cid7, cid8, cid9, cid10, cid11, 
			cid12, cid13, cid14, cid15, cid16, cid17, cid18, cid19, cid20, cid21, cid22));	
	}
}
