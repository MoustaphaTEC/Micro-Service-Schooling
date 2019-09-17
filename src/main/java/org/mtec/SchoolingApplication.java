package org.mtec;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SchoolingApplication implements CommandLineRunner{
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		
		Formation f1= formationRepository.save(new Formation(null,"JAVA",30,null));
		Formation f2= formationRepository.save(new Formation(null,"PHP",30,null));
		Formation f3= formationRepository.save(new Formation(null,"Oracle",30,null));

		
		
		etudiantRepository.save(new Etudiant(null,"Moustapha","Diouf",new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Diegane","Diouf",new Date(),f3));
		etudiantRepository.save(new Etudiant(null,"Khady","Ndiaye",new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"Fatou","Leye ",new Date(),f1));

	}

}
