package usuario;

import cadastro.Cadastro;

//import java.util.ArrayList;
//import java.util.Collections;

// Classe Usuario representa um usuário com informações adicionais de cadastro
public class Usuario implements Comparable<Usuario> {
	private String nome;
    private String cpf;
    private Cadastro cadastro;

    public Usuario() {
    }

    // Getter e Setter para cada atributo
    public Usuario(String nome, String cpf, Cadastro cadastro) {
        this.nome = nome;
        this.cpf = cpf;
		this.cadastro = cadastro;
	}
	
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
	
	public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + cadastro.getEndereco());
        System.out.println("Municipio: " + cadastro.getMunicipio());
        System.out.println("Celular: " + cadastro.getCelular());
        System.out.println("Genero: " + cadastro.getGenero());
		System.out.println("Idade: " + cadastro.getIdade());
    }

    @Override
    public int compareTo(Usuario outroUsuario) {
        return this.nome.compareToIgnoreCase(outroUsuario.nome);
    }
	
	public boolean validarcpf() {
        // Remover caracteres não numéricos do CPF
        String cpfNumerico = this.cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpfNumerico.length() != 11) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpfNumerico.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpfNumerico.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificar se os dígitos verificadores estão corretos
        return (Character.getNumericValue(cpfNumerico.charAt(9)) == digitoVerificador1 &&
                Character.getNumericValue(cpfNumerico.charAt(10)) == digitoVerificador2);
    }
}
