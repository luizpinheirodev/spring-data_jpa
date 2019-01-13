package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query(value = "select funcConcatAddress(?1)",
			nativeQuery=true)
	String functionNativeQueryConcatenaEndereco(Long id);
		
	// usando a function com @namedNativeQuery
	String functionConcatenaEndereco(Long id);
	
	@Query(value = "select * from Addresses a where city like ?1 and street like ?2", 
			nativeQuery = true)
	Address buscaPorCidadeRua(String city, String street);

	// usando namedNativeQueries
	Address buscaPorEndereco(String city, String street);

	// usando @NamedQuery na entidade
	List<Address> buscaPorCidade(String cidade);

	// busca por city e ordena por type de forma descendente
	List<Address> findByCityOrderByTypeDesc(String city);

	// busca por city ou street conforme a igualdade de sequencia de caracter
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);

	// busca por street conforme o parametro coincida com qualquer parte do
	// campo street
	List<Address> findByStreetContaining(String street);

	// busca por street conforme o fim da palavra
	List<Address> findByStreetEndingWith(String street);

	// busca por city conforme o inicio da palavra
	List<Address> findByCityStartingWith(String city);

}
