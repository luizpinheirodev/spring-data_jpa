package br.com.devmedia.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import br.com.devmedia.curso.entity.Address;
import br.com.devmedia.curso.entity.Address.TypeAddress;
import br.com.devmedia.curso.entity.Document;
import br.com.devmedia.curso.entity.Person;
import br.com.devmedia.curso.entity.Phone;
import br.com.devmedia.curso.entity.Phone.TypePhone;
import br.com.devmedia.curso.repository.AddressRepository;
import br.com.devmedia.curso.repository.DocumentRepository;
import br.com.devmedia.curso.repository.PersonRepository;
import br.com.devmedia.curso.repository.PhoneRepository;

@SpringBootApplication
//@ImportResource(value = "spring-data.xml")
public class CursoSpringDataApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private PhoneRepository phoneRepository; 
	
    public static void main(String[] args) {
        SpringApplication.run(CursoSpringDataApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		//testConfiguration();
		
		//testSave();
		//testUpdate();
		//testDelete();
		
		//testSavePersons();
		//testDeletePersons();
		
		//testFindAndSort();
		//testFindById();
		//testExists();
		
		//testPagination();
		
		//testByAge();
		//testByFirstNameLikw();
		//testByAndOr();
		//testByBetween();
		//testByLastNameAndBetween();
		
		//testByGreaterAndLess();
		//testByGreaterAndLessEquals();
		//testByFirstNameGreaterThan();
		
		//testByStartingAndEnd();
		//testByContaing();
		//testByAddressStartAndEnding();
		
		//testByInAndNotIn();
		//testByOrderBy();
		//testIgnoreCase();
		
		//testByNotNullAndNull();
		
		//testPhonesByNumber();
		//testFindByGreaterThanAndOrder();
		
		//findFirstName();
		//findFirstNameOrAge();
		//findFirstNameAndAge();
		//findByCPFEndsWith();
		//findPersonByAges();
		//findPersonByNames();
		//findDocumentByCPFStart();
		
		//findAddressPorCidade();
		findAddressesPorEndereco();
	}

	private void findAddressesPorEndereco() {
		Address addresses = addressRepository.buscaPorEndereco("Rio de Janeiro", "Av. Copacabana, 102");
		System.out.println(addresses.toString());
		
		Address addresses2 = addressRepository.buscaPorCidadeRua("Rio de Janeiro", "Av. Copacabana, 102");
		System.out.println(addresses2.toString());
	}

	private void findAddressPorCidade() {
		List<Address> addresses = addressRepository.buscaPorCidade("Porto Alegre");
		addresses.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void findDocumentByCPFStart() {
		List<Document> documents = documentRepository.findByCPFStartWith("445");
		documents.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void findPersonByNames() {
		List<Person> p1 = personRepository.findByFirstNames("Aline", "Bruna", "Gilson", "Ana Maria");
		p1.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void findPersonByAges() {
		List<Person> p1 = personRepository.findByAgeBetween(28, 36);
		p1.forEach(System.out::println);	
	}

	@SuppressWarnings("unused")
	private void findByCPFEndsWith() {
		List<Person> p1 = personRepository.findByDocumentCPFEndsWith("98");
		p1.forEach(System.out::println);	
	}

	@SuppressWarnings("unused")
	private void findFirstNameAndAge() {
		List<Person> p1 = personRepository.findByFirstNameAndAge(29, "Fabiana");
		p1.forEach(System.out::println);		
	}

	@SuppressWarnings("unused")
	private void findFirstNameOrAge() {
		List<Person> p1 = personRepository.findByFirstNameOrAge("Aline", 29);
		p1.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void findFirstName() {
		List<Person> p1 = personRepository.findByFirstName("Aline");
		p1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testFindByGreaterThanAndOrder() {
		List<Person> p1 = personRepository.findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(22);
		p1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testPhonesByNumber() {
		List<Person> p1 = personRepository.findByPhonesNumberStartingWith("3222");
		p1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByNotNullAndNull() {
		List<Person> p1 = personRepository.findByDocumentIsNull();
		p1.forEach(System.out::println);
		
		System.out.println("-------------------------------");
		
		List<Person> p2 = personRepository.findByDocumentIsNotNull();
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testIgnoreCase() {
		
		List<Person> p1 = personRepository.findByFirstNameIgnoreCase("BRUnA");
		p1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByOrderBy() {
		
		List<Address> a1 = addressRepository.findByCityOrderByTypeDesc("Rio de Janeiro");
		a1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByInAndNotIn() {
		List<Person> p1 = personRepository.findByAgeIn(24, 28, 36, 45);
		p1.forEach(System.out::println);
		
		System.out.println("-------------------------------");
		
		List<Person> p2 = personRepository.findByAgeNotIn(24, 28, 36, 45);
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByAddressStartAndEnding() {
		
		List<Address> a1 = addressRepository.findByCityStartingWithOrStreetEndingWith("Rio", "102");
		a1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByContaing() {
		
		List<Address> a1 = addressRepository.findByStreetContaining("Ipanema");
		a1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByStartingAndEnd() {
		List<Address> a1 = addressRepository.findByCityStartingWith("Rio");
		a1.forEach(System.out::println);
		
		System.out.println("-------------------------------");

		List<Address> a2 = addressRepository.findByStreetEndingWith("102");
		a2.forEach(System.out::println);		
	}

	@SuppressWarnings("unused")
	private void testByFirstNameGreaterThan() {
		
		List<Person> p1 = personRepository.findByFirstNameGreaterThan("Jorge");
		p1.forEach(System.out::println);		
		
	}

	@SuppressWarnings("unused")
	private void testByGreaterAndLessEquals() {

		List<Person> p1 = personRepository.findByAgeGreaterThanEqual(25);
		p1.forEach(System.out::println);
		
		System.out.println("-------------------------------");

		List<Person> p2 = personRepository.findByAgeLessThanEqual(25);
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByGreaterAndLess() {
		List<Person> p1 = personRepository.findByAgeGreaterThan(28);
		p1.forEach(System.out::println);
		
		System.out.println("-------------------------------");

		List<Person> p2 = personRepository.findByAgeLessThan(28);
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByLastNameAndBetween() {
		
		List<Person> p1 = personRepository.findByLastNameAndAgeBetween("Pereira", 25, 45);
		p1.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByBetween() {
		List<Person> p1 = personRepository.findByAgeBetween(24, 29);
		p1.forEach(System.out::println);		
	}

	@SuppressWarnings("unused")
	private void testByAndOr() {
		Person p1 = personRepository.findByFirstNameAndLastName("João", "Pereira");
		System.out.println(p1.toString());
		
		List<Person> p2 = personRepository.findByAgeOrFirstName(33, "Fabiane");
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testByFirstNameLikw() {
		List<Person> p1 = personRepository.findByFirstNameLike("Maria");
		p1.forEach(System.out::println);
		System.out.println("-------------------------------");
		
		List<Person> p2 = personRepository.findByFirstNameNotLike("Maria");
		p2.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void testByAge() {
		List<Person> p1 = personRepository.findByAge(25);
		p1.forEach(System.out::println);
		System.out.println("-------------------------------");

		List<Person> p2 = personRepository.findByAgeNot(25);
		p2.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testPagination() {

		Page<Person> pages = personRepository.findAll(new PageRequest(0, 2));
		pages.getContent().forEach(System.out::println);

		pages = personRepository.findAll(new PageRequest(1, 2));
		pages.getContent().forEach(System.out::println);
		
		pages = personRepository.findAll(new PageRequest(2, 2));
		pages.getContent().forEach(System.out::println);

	}

	@SuppressWarnings("unused")
	private void testExists() {
		
		boolean p1 = personRepository.exists(19L);
		System.out.println("P1 is " + p1);
		
		boolean p2 = personRepository.exists(50L);
		System.out.println("P2 is " + p2);

	}

	@SuppressWarnings("unused")
	private void testFindById() {
		
		List<Person> persons = personRepository.findAll(Arrays.asList(17L, 18L, 14L));
		persons.forEach(System.out::println);
		
	}

	@SuppressWarnings("unused")
	private void testFindAndSort() {
		
		Order orderAsc = new Order(Direction.ASC, "lastName");
		Order orderDesc = new Order(Direction.ASC, "firstName");
		
		Sort sort = new Sort(orderAsc, orderDesc);
		
		List<Person> persons = personRepository.findAll(sort);
		persons.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void testDeletePersons() {
		Person p1 = personRepository.findOne(2L);
		Person p2 = personRepository.findOne(3L);
		Person p3 = personRepository.findOne(4L);
		
		//executa delete um a um
		personRepository.delete(Arrays.asList(p1, p2, p3));
		
		System.out.println("***********************************");
		
		Person p4 = personRepository.findOne(5L);
		Person p5 = personRepository.findOne(6L);
		Person p6 = personRepository.findOne(7L);
		
		//executa delete de uma só vez
		personRepository.deleteInBatch(Arrays.asList(p4, p5, p6));

		System.out.println("***********************************");
	}

	@SuppressWarnings("unused")
	private void testSavePersons() {
		
		Person p1 = new Person();
		p1.setFirstName("Maria");
		p1.setLastName("Souza");
		p1.setAge(25);
		p1.setDocument(new Document("841.843.888-01", 1222222222));
		
		Person p2 = new Person();
		p2.setFirstName("João");
		p2.setLastName("Pereira");
		p2.setAge(63);
		p2.setDocument(new Document("841.843.888-02", 1333333333));
		
		Person p3 = new Person();
		p3.setFirstName("Paulo Ricardo");
		p3.setLastName("Pereira");
		p3.setAge(45);
		p3.setDocument(new Document("841.843.888-03", 1444444444));

		Person p4 = new Person();
		p4.setFirstName("Fabiane");
		p4.setLastName("Guimarães");
		p4.setAge(33);
		p4.setDocument(new Document("841.843.888-04", 1555555555));
		
		Person p5 = new Person();
		p5.setFirstName("Jorge");
		p5.setLastName("Pereira");
		p5.setAge(25);
		p5.setDocument(new Document("841.843.888-05", 1666666666));
		
		Person p6 = new Person();
		p6.setFirstName("Carlos");
		p6.setLastName("Ribas");
		p6.setAge(23);
		p6.setDocument(new Document("841.843.888-06", 1777777777));
		
		/*
		List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);
		for(Person p : persons){
			personRepository.save(p);
		}
		*/
		
		List<Person> persons = 
				personRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		persons.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void testDelete() {
		//personRepository.delete(1L);
		
		Person person = personRepository.findOne(1L);
		personRepository.delete(person);
		
	}

	@SuppressWarnings("unused")
	private void testUpdate() {
		Person person = personRepository.findOne(1L);
		System.out.println(person.toString());
		
		person.setLastName("Aguiar");
		
		personRepository.save(person);
		
		Person person2 = personRepository.findOne(1L);
		System.out.println(person2.toString());
	}

	@SuppressWarnings("unused")
	private void testSave() {

		Person person = new Person();
		person.setFirstName("João Luiz");
		person.setLastName("Rios");
		person.setAge(35);
		person.setDocument(new Document("841.843.888-00", 1111111111));
		
		Address address = new Address();
		address.setCity("Manaus");
		address.setStreet("Rua das Valquirias, 10");
		address.setType(TypeAddress.RESIDENCIAL);
		
		person.setAddresses(Arrays.asList(address));
		person.addPhone(new Phone(TypePhone.RESIDENCIAL, "11111111"));

		personRepository.save(person);
		
		Person p2 = personRepository.findOne(person.getId());
		
		System.out.println(p2.toString());
	}

	@SuppressWarnings("unused")
	private void testConfiguration() {
		
		long total = personRepository.count();		
		System.out.println("Total of persons = " + total);
		
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
		
		long t2 = addressRepository.count();		
		System.out.println("Total of addresses = " + t2);
		
		long t3 = documentRepository.count();		
		System.out.println("Total of documents = " + t3);
		
		long t4 = phoneRepository.count();		
		System.out.println("Total of phones = " + t4);
		
	}
}
