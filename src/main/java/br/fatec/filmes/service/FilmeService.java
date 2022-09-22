package br.fatec.filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.filmes.model.Filme;
import br.fatec.filmes.repository.FilmeRepository;

@Service
public class FilmeService implements ServiceInterface<Filme> {
	@Autowired
	private FilmeRepository repository;
	
	public FilmeService() {}
	
	@Override
	public Filme create(Filme obj) {
		repository.save(obj);
		return obj;
	}
	
	@Override
	public List<Filme> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Filme findById(Long id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public boolean update(Filme obj) {
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
