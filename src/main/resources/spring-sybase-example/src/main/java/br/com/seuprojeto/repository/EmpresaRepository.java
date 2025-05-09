package br.com.seuprojeto.repository;

import br.com.seuprojeto.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}