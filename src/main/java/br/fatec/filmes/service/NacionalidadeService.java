package br.fatec.filmes.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.filmes.model.Nacionalidade;
import br.fatec.filmes.repository.NacionalidadeRepository;

@Service
public class NacionalidadeService implements ServiceInterface<Nacionalidade> {
	@Autowired
	private NacionalidadeRepository repository;
	
	public NacionalidadeService() {}
	
	@Override
	public Nacionalidade create(Nacionalidade obj) {
		repository.save(obj);
		return obj;
	}
	
	@Override
	public List<Nacionalidade> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Nacionalidade findById(Long id) {
		Optional<Nacionalidade> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public boolean update(Nacionalidade obj) {
		if(repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}
	
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	} 
}
