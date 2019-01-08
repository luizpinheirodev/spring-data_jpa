package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	// busca por city e ordena por type de forma descendente
	List<Address> findByCityOrderByTypeDesc(String city);
	
	// busca por city ou street conforme a igualdade de sequencia de caracter
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);
	
	// busca por street conforme o parametro coincida com qualquer parte do campo street
	List<Address> findByStreetContaining(String street);
	
	// busca por street conforme o fim da palavra
	List<Address> findByStreetEndingWith(String street);
	
	// busca por city conforme o inicio da palavra
	List<Address> findByCityStartingWith(String city);
	
}
