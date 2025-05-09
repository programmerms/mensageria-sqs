package br.com.seuprojeto.service;

import br.com.seuprojeto.domain.Empresa;
import br.com.seuprojeto.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa salvar(Empresa empresa) {
        return repository.save(empresa);
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}