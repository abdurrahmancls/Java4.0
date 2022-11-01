package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languagerepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languagerepository) {
		this.languagerepository = languagerepository;
	}

	@Override
	public List<Language> getAll() {
		//İş kuralları
		return languagerepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return languagerepository.getById(id);
	}

	@Override
	public void create(Language language) throws Exception {
		if(language.getName().isEmpty()) {
			throw new Exception("Boş bırakılamaz");
		}
		for(Language language1: getAll()) {
			if(language1.getId()== language.getId()) {
				throw new Exception("Aynı isimde 2 dil olmaz");
			}
		}
		languagerepository.create(language);
		
	}

	@Override
	public void update(Language language, int id) throws Exception{
		if(languagerepository.getById(id)==null) {
			throw new Exception("Sistemde Kayıtlı değil");
		}
		languagerepository.update(language, id);
		
	}

	@Override
	public void delete(int id) throws Exception {
		languagerepository.delete(id);
		
	}

	@Override
	public void update(Language language) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
