package com.example.nuevoparking;

import java.util.ArrayList;

public class Session {

    private static Entrada entrada = null;

    private static Integer pos = null;

    private static ArrayList<Entrada> entradas = new ArrayList<>(0);

    private static Cliente cliente = null;

    private static ArrayList<Cliente> clientes = new ArrayList<>(0);

    public static Entrada getEntrada() {
        return entrada;
    }

    public static void setEntrada(Entrada entrada) {
        Session.entrada = entrada;
    }

    public static Integer getPos() {
        return pos;
    }

    public static void setPos(Integer pos) {
        Session.pos = pos;
    }

    public static ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public static void setEntradas(ArrayList<Entrada> entradas) {
        Session.entradas = entradas;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Session.cliente = cliente;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Session.clientes = clientes;
    }
}
