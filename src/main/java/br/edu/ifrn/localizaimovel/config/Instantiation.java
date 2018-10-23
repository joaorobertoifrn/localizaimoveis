package br.edu.ifrn.localizaimovel.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifrn.localizaimovel.domain.Cidade;
import br.edu.ifrn.localizaimovel.domain.Endereco;
import br.edu.ifrn.localizaimovel.domain.Imovel;
import br.edu.ifrn.localizaimovel.domain.User;
import br.edu.ifrn.localizaimovel.repository.CidadeRepository;
import br.edu.ifrn.localizaimovel.repository.EnderecoRepository;
import br.edu.ifrn.localizaimovel.repository.ImovelRepository;
import br.edu.ifrn.localizaimovel.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		// Limpar os registros no banco
		userRepository.deleteAll();
		imovelRepository.deleteAll();
		cidadeRepository.deleteAll();
		enderecoRepository.deleteAll();
		
		// Cria Usuarios no banco
		User maria = new User(null, "Maria Brown", "maria@usuario.com.br");
		User alex = new User(null, "Alex Green", "alex@usuario.com.br");
		User bob = new User(null, "Bob Gray", "bob@usuario.com.br");
		User joao = new User(null, "João Pereira", "joao@usuario.com.br");
		User marcos = new User(null, "Marcos Blue", "marcos@usuario.com.br");
		User andre = new User(null, "André Silva", "andre@usuario.com.br");
		
		Cidade cidade1 = new Cidade(null,"Natal","RN");
		Cidade cidade2 = new Cidade(null,"Parnamirim","RN");
		Cidade cidade3 = new Cidade(null,"Campina Grande","PB");
		Cidade cidade4 = new Cidade(null,"João Pessoa","PB");
		
		Endereco endereco1 = new Endereco(null,"Rua Aeroporto de Navegantes, 366","Emaus");
		Endereco endereco2 = new Endereco(null,"Rua Aeroporto de Joinville, 100","Emaus");
		Endereco endereco3 = new Endereco(null,"Avenida Flavio Ribeiro Coutinho, 500","Manaria");
		Endereco endereco4 = new Endereco(null,"Avenida Edson Ramalho, 1052","Manaria");
		Endereco endereco5 = new Endereco(null,"Avenida Romualdo Galvão, 5653","Lagoa Nova");
		Endereco endereco6 = new Endereco(null,"Avenida Prudente de Moraes, 6544","Petropolis");
		Endereco endereco7 = new Endereco(null,"Rua Matias de Vasconcelos Costa, 322","Sandra Cavalcante");
		Endereco endereco8 = new Endereco(null,"Rua Antonio Vilarim, 52","Sandra Cavalcante");

		Imovel imovel1 = new Imovel(null, "Casa com 3 quartos","2000000","sem foto","http://caixa.gov.br",cidade3,endereco7);
		Imovel imovel2 = new Imovel(null, "Casa com 3 quartos, 2 Banheiros","2500000","sem foto","http://caixa.gov.br",cidade3,endereco8);
		Imovel imovel3 = new Imovel(null, "Apartamento com 2 quartos, sem garagem","1000000","sem foto","http://caixa.gov.br",cidade1,endereco5);
		Imovel imovel4 = new Imovel(null, "Apartamento com 3 quartos, com garagem","3000000","sem foto","http://caixa.gov.br",cidade1,endereco6);
		Imovel imovel5 = new Imovel(null, "Casa com 3 quartos, com piscina","2500000","sem foto","http://caixa.gov.br",cidade2,endereco1);
		Imovel imovel6 = new Imovel(null, "Casa com 2 quartos, 2 WC","1500000","sem foto","http://caixa.gov.br",cidade2,endereco2);
		Imovel imovel7 = new Imovel(null, "Flat 2 quartos","2500000","sem foto","http://caixa.gov.br",cidade4,endereco3);
		Imovel imovel8 = new Imovel(null, "Apartamento com 3 quartos, 2 vagas na garagem","2000000","sem foto","http://caixa.gov.br",cidade4,endereco4);
		// Salvar os registros no banco
		userRepository.saveAll(Arrays.asList(maria,alex,bob,joao,marcos,andre));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4,endereco5,endereco6,endereco7,endereco8));
		imovelRepository.saveAll(Arrays.asList(imovel1,imovel2,imovel3,imovel4,imovel5,imovel6,imovel7,imovel8));
		
	}

}
