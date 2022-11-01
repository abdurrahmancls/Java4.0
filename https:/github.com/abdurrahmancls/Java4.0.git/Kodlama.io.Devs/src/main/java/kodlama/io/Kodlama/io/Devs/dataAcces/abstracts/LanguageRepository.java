package kodlama.io.Kodlama.io.Devs.dataAcces.abstracts;

import java.util.List;


import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;


public interface LanguageRepository {
	List<Language> getAll();

	Language getById(int id) throws Exception;
	
	void create(Language language);

	void update(Language language, int id) throws Exception;

	void delete(int id) throws Exception;
	
}
