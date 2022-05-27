package com.example.demo.medcin;

import java.util.List;





public interface MedcinService {

	List<medcin> getAllMedcins();
	void saveMedcin(medcin medcin);
	medcin getMedcinById(long id);
	void deleteMedcinById(long id);
}
