package br.com.seuprojeto;

import br.com.seuprojeto.repository.TestSybaseRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SybaseConnectionTester {

    private final TestSybaseRepository repository;

    public SybaseConnectionTester(TestSybaseRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void testConnection() {
        var rows = repository.fetchTopRows();
        System.out.println("Linhas retornadas: " + rows.size());
        rows.forEach(System.out::println);
    }
}
