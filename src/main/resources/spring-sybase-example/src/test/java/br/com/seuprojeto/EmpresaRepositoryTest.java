package br.com.seuprojeto;

import br.com.seuprojeto.domain.Empresa;
import br.com.seuprojeto.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpresaRepositoryTest {

    @Autowired
    EmpresaRepository repository;

    @Test
    void testSalvarBuscarExcluir() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa X");
        empresa.setNomeFantasia("Fantasia X");

        Empresa salva = repository.save(empresa);
        System.out.println("Salvo: " + salva.getId());

        repository.findById(salva.getId()).ifPresent(e -> {
            System.out.println("Encontrado: " + e.getRazaoSocial());
        });

        repository.deleteById(salva.getId());
        System.out.println("Excluído com sucesso.");
    }
}