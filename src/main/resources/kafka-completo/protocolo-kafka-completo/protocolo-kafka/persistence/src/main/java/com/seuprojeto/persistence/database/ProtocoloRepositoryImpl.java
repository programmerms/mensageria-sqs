
package com.seuprojeto.persistence.database;

import com.seuprojeto.domain.model.Protocolo;
import com.seuprojeto.persistence.ProtocoloRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class ProtocoloRepositoryImpl implements ProtocoloRepository {
    @Override
    public Protocolo buscarPorNumero(String numero) {
        // Simulando busca no banco de dados
        return new Protocolo(numero, "ABERTO", LocalDate.now());
    }
}
