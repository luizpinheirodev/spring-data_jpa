package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	// busca por lastName and age between
	List<Person> findByLastNameAndAgeBetween(String lastName, int min, int max);
	
	// busca por age between (inclusive)
	List<Person> findByAgeBetween(int min, int max);
	
	// busca por age or firstName via parametros
	List<Person> findByAgeOrFirstName(Integer age, String firstName);
	
	// busca por firstName and lastName
	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	// busca por firstName igual ao parametro
	List<Person> findByFirstNameLike(String first);
	
	// busca por firstName diferente ao parametro
	List<Person> findByFirstNameNotLike(String first);
	
	// busca por age igual ao parametro fornecido
	List<Person> findByAge(Integer age);
	
	// busca por age diferente ao parametro fornecido
	List<Person> findByAgeNot(Integer age);
	
}
