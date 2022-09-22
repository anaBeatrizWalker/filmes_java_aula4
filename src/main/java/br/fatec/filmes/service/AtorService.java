package br.fatec.filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.filmes.model.Ator;
import br.fatec.filmes.repository.AtorRepository;

@Service
public class AtorService implements ServiceInterface<Ator> {
	@Autowired
	private AtorRepository repository;
	
	public AtorService() {}
	
	@Override
	public Ator create(Ator obj) {
		repository.save(obj);
		return obj;
	}
	
	@Override
	public List<Ator> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Ator findById(Long id) {
		Optional<Ator> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public boolean update(Ator obj) {
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
