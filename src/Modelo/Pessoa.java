package Modelo;

import java.sql.Date;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
    private int idade;
    private boolean areasaude;
    private String endereco;
    private Date dataVacinacao;
    private int id;

    public Pessoa() {
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(String nome, int idade, String endereco, boolean areasaude) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.areasaude = areasaude;
    }

    
    public Pessoa(String nome, int idade, boolean areasaude, Date dataVacinacao){
        this.nome = nome;
        this.idade = idade;
        this.areasaude = areasaude;
        this.dataVacinacao = dataVacinacao;
    }
    
    public Pessoa(String nome, int idade, String endereco, boolean areasaude, Date dataVacinacao) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.areasaude = areasaude;
        this.dataVacinacao = dataVacinacao;
    }

    public Pessoa(String nome, int idade, String endereco, boolean areasaude, Date dataVacinacao, int id) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.areasaude = areasaude;
        this.dataVacinacao = dataVacinacao;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAreasaude() {
        return areasaude;
    }

    public void setAreasaude(boolean areasaude) {
        this.areasaude = areasaude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }
    
    //METODO PARA COMPARABLE DAS PESSOAS
    public int compareTo(Pessoa o) {
        //COMPARANDO IDADE
        if (this.idade >= 70 && o.getIdade() < 70) {
            return -1;
        } else if (this.idade < 70 && o.getIdade() >= 70) {
            return 1;
            //COMPARANDO PROFISSAO
        } else if (this.areasaude == true && o.isAreasaude() == false) {
            return -1;
        } else if (this.areasaude == false && o.isAreasaude() == true) {
            return 1;
        }
        return 0;
    }
}