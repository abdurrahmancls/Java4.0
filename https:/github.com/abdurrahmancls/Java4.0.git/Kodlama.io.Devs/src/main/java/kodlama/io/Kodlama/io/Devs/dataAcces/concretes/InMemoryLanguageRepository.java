package kodlama.io.Kodlama.io.Devs.dataAcces.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;


@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	
	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"C++"));
		languages.add(new Language(4,"Javascript"));
		languages.add(new Language(5,"Kotlin"));
		languages.add(new Language(6,"Swift"));
		
	}

	@Override
	public List<Language> getAll() {
		
		return languages;
	}
	
	@Override
	public Language getById(int id) throws Exception {
		for(Language language: languages) {
			if(language.getId()==id) {
				return language;
			}
		}
		throw new Exception("Kayıt bulunamadı");
	}
	
	@Override
	public void create(Language language) {
		languages.add(language);
	}
	
	@Override
	public void update(Language language ,int id) throws Exception {
		Language language1=getById(language.getId());
		language1.setName(language.getName());
		
	}
	
	@Override
	public void delete(int id) throws Exception{
		Language language1=getById(id);
		languages.remove(language1);
	}
	
}






