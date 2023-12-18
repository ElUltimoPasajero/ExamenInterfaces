package com.example.nuevoparking;


import java.time.LocalDate;


public class Entrada {

    private  String matricula;

    private String modelo;

    private LocalDate fechaEntrada;

    private LocalDate fechaSalida;

    private Cliente cliente;

    private String tarifa;

    private Double coste;

    public Entrada(String matricula, String modelo, LocalDate fechaEntrada, LocalDate fechaSalida, Cliente cliente, String tarifa, Double coste) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.coste = coste;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }
}
