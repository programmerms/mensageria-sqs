
package com.seuprojeto.domain.model;

import java.time.LocalDate;

public class Protocolo {
    private String numero;
    private String status;
    private LocalDate dataAbertura;

    public Protocolo() {}

    public Protocolo(String numero, String status, LocalDate dataAbertura) {
        this.numero = numero;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }
}
