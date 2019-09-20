/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Professor extends Pessoa{
    private long siape;

    public Professor(String nome, String sexo, long cpf, int idade){
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }
    
    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }
}
