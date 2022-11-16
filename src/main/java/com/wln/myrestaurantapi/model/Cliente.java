package com.wln.myrestaurantapi.model;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private boolean ativar = false;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivar() {
        return ativar;
    }

    public void setAtivar(boolean ativar) {
        this.ativar = ativar;
    }


}
