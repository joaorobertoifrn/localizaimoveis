package br.edu.ifrn.localizaimovel.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifrn.localizaimovel.domain.User;
import br.edu.ifrn.localizaimovel.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		// Limpar os registros no banco
		userRepository.deleteAll();
		
		// Cria Usuarios no banco
		User maria = new User(null, "Maria Brown", "maria@usuario.com.br");
		User alex = new User(null, "Alex Green", "alex@usuario.com.br");
		User bob = new User(null, "Bob Gray", "bob@usuario.com.br");
		User joao = new User(null, "João Pereira", "joao@usuario.com.br");
		User marcos = new User(null, "Marcos Blue", "marcos@usuario.com.br");
		User andre = new User(null, "André Silva", "andre@usuario.com.br");
		
		// Salvar os registros no banco
		userRepository.saveAll(Arrays.asList(maria,alex,bob,joao,marcos,andre));
	}

}
