
package com.seuprojeto.infrastructure.kafka;

import com.seuprojeto.domain.model.Protocolo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProtocoloProducerAdapter {

    private final KafkaTemplate<String, Protocolo> kafkaTemplate;

    public ProtocoloProducerAdapter(KafkaTemplate<String, Protocolo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(Protocolo protocolo) {
        kafkaTemplate.send("topico-protocolo", protocolo);
    }
}
