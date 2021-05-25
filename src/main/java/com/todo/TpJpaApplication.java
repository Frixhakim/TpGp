package com.todo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.todo.entities.Patient;
import com.todo.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		patientRepository.save(new Patient(null,"Frix", new Date(), 2300 , false));
		patientRepository.save(new Patient(null,"hakim",new Date(), 3000 , true));
		patientRepository.save(new Patient(null,"anis",new Date(), 3500 , false));
		patientRepository.save(new Patient(null,"revo",new Date(), 2000 , true));
		patientRepository.save(new Patient(null,"yassine",new Date(), 5000 , true));
		patientRepository.save(new Patient(null,"ayoube",new Date(), 6000 , true));
		


		System.out.println("************************************");

		patientRepository.findAll().forEach(p->{System.out.println(p.toString());
		});
		
		System.out.println("************************************");
		Patient patient=patientRepository.findById(4L).get();
		System.out.println(patient.toString());
		/*
		 * System.out.println("************************************"); List<Patient>
		 * patients = patientRepository.findByNomContains("a");
		 * patients.forEach(p->{System.out.println(p.toString()); });
		 
		 	
		 	System.out.println("************************************");
		List<Patient> patients2 = patientRepository.findByMalade(false);
		patients2.forEach(p->{System.out.println(p.toString());
		});
		System.out.println("************************************");
		List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("a",true);
		patients3.forEach(p->{System.out.println(p.toString());
		});
	
		patientRepository.deleteById(3L);
		
		System.out.println("************************************");
		Page<Patient> PagePatients = patientRepository.findAll(PageRequest.of(0, 2));
		PagePatients.getContent() .forEach(p->{System.out.println(p.toString());
		});
		*/
		
	}

}
