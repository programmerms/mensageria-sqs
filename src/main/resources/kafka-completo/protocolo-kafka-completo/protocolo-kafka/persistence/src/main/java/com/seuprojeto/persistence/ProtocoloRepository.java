
package com.seuprojeto.persistence;

import com.seuprojeto.domain.model.Protocolo;

public interface ProtocoloRepository {
    Protocolo buscarPorNumero(String numero);
}
