package br.edu.ifrn.localizaimovel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.localizaimovel.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
