package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devmedia.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("select p from Person p where p.firstName in :names order by p.age asc")
	List<Person> findByFirstNames(@Param("names")String... firstName);

	@Query("select p from Person p where p.age >= :min and p.age <= :max")
	List<Person> findByAgeBetween(@Param("min")Integer start, @Param("max")Integer end);
	
	@Query("select p from Person p where p.document.cpf like %?1")
	List<Person> findByDocumentCPFEndsWith(String value);
	
	@Query("select p from Person p where p.firstName like ?2 and p.age=?1")
	List<Person> findByFirstNameAndAge(Integer age, String firstName);

	@Query("select p from Person p where p.firstName like ?1 or p.age=?2")
	List<Person> findByFirstNameOrAge(String firstName, Integer age);
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	// busca por age e ordena por firstName e lastName
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer age);
	
	// busca por number via phones mapeados em person
	List<Person> findByPhonesNumberStartingWith(String number);
	
	// busca por document não são null
	List<Person> findByDocumentIsNotNull();

	// busca por document null
	List<Person> findByDocumentIsNull();
	
	// busca por firstName ignorando letras maiusculas/minuscula
	List<Person> findByFirstNameIgnoreCase(String firstName);
	
	// busca por age baseada em uma lista de parametros que será negada
	List<Person> findByAgeNotIn(Integer... ages);
	
	// busca por age baseada em uma lista de parametros
	List<Person> findByAgeIn(Integer... ages);
	
	//
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	// busca por age menor ou iguai ao parametro
	List<Person> findByAgeLessThanEqual(Integer age);
	
	// busca por age maior ou iguai ao parametro
	List<Person> findByAgeGreaterThanEqual(Integer age);
		
	// busca por age menor que o parametro
	List<Person> findByAgeLessThan(Integer age);
	
	// busca por age maior que o parametro
	List<Person> findByAgeGreaterThan(Integer age);
	
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
