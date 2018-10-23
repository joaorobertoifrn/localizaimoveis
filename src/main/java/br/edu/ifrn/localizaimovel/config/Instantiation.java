package br.edu.ifrn.localizaimovel.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifrn.localizaimovel.domain.Cidade;
import br.edu.ifrn.localizaimovel.domain.Endereco;
import br.edu.ifrn.localizaimovel.domain.Imovel;
import br.edu.ifrn.localizaimovel.domain.Pesquisa;
import br.edu.ifrn.localizaimovel.domain.User;
import br.edu.ifrn.localizaimovel.repository.CidadeRepository;
import br.edu.ifrn.localizaimovel.repository.EnderecoRepository;
import br.edu.ifrn.localizaimovel.repository.ImovelRepository;
import br.edu.ifrn.localizaimovel.repository.PesquisaRepository;
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

	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// Limpar os registros no banco
		userRepository.deleteAll();
		imovelRepository.deleteAll();
		cidadeRepository.deleteAll();
		enderecoRepository.deleteAll();
		pesquisaRepository.deleteAll();
		
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

		Pesquisa pesquisa1 = new Pesquisa(null,imovel4,sdf.parse("22/10/2018"));
		Pesquisa pesquisa2 = new Pesquisa(null,imovel5,sdf.parse("21/10/2018"));
		Pesquisa pesquisa3 = new Pesquisa(null,imovel4,sdf.parse("20/10/2018"));
		Pesquisa pesquisa4 = new Pesquisa(null,imovel6,sdf.parse("20/10/2018"));
		Pesquisa pesquisa5 = new Pesquisa(null,imovel7,sdf.parse("21/10/2018"));
		Pesquisa pesquisa6 = new Pesquisa(null,imovel8,sdf.parse("19/10/2018"));
		Pesquisa pesquisa7 = new Pesquisa(null,imovel3,sdf.parse("15/10/2018"));
		Pesquisa pesquisa8 = new Pesquisa(null,imovel4,sdf.parse("16/10/2018"));
		Pesquisa pesquisa9 = new Pesquisa(null,imovel5,sdf.parse("09/10/2018"));
		Pesquisa pesquisa10 = new Pesquisa(null,imovel2,sdf.parse("01/10/2018"));
		
		
		// Salvar os registros no banco
		userRepository.saveAll(Arrays.asList(maria,alex,bob,joao,marcos,andre));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4,endereco5,endereco6,endereco7,endereco8));
		imovelRepository.saveAll(Arrays.asList(imovel1,imovel2,imovel3,imovel4,imovel5,imovel6,imovel7,imovel8));
		pesquisaRepository.saveAll(Arrays.asList(pesquisa1,pesquisa2,pesquisa3,pesquisa4,pesquisa5,pesquisa6,pesquisa7,pesquisa8,pesquisa9,pesquisa10));
		
		// Associando as pesquisas aos usuarios
		joao.getPesquisas().addAll(Arrays.asList(pesquisa1,pesquisa10));
		maria.getPesquisas().addAll(Arrays.asList(pesquisa2,pesquisa9));
		alex.getPesquisas().addAll(Arrays.asList(pesquisa3));
		bob.getPesquisas().addAll(Arrays.asList(pesquisa4,pesquisa8));
		marcos.getPesquisas().addAll(Arrays.asList(pesquisa5,pesquisa7));
		andre.getPesquisas().addAll(Arrays.asList(pesquisa6));
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,joao,marcos,andre));
		
	}

}
