package cadastro;

import java.util.regex.Pattern;

// Classe Cadastro representa os dados pessoais de um usuário
public class Cadastro {
    private String nome;
    private String endereco;
    private String municipio;
    private String celular;
    private String genero;
    private int idade;

    public Cadastro() {
    }

    // Getter e Setter para cada atributo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
	
	public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
	
	public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
	
	public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
	
    public int getIdade() {
        return idade;
    }
	
	public void setIdade(int idade) {
    if (validarIdade(idade)) {
        this.idade = idade;
    } else {
        System.out.println("Idade inválida. Por favor, insira um valor válido.");
    }
}

	// Método de validação de idade
	public boolean validarIdade(int idade) {
		return idade > 0;
	}


    // Métodos de validação
    public boolean validarIdade() {
        return idade > 0;
    }

	
	public boolean validarCelular() {
        // Utilizando expressão regular para verificar se o formato do celular é válido
        String regex = "^(\\+\\d{1,2}\\s?)?(\\(\\d{1,4}\\)\\s?)?\\d{1,}$";
        Pattern pattern = Pattern.compile(regex);

        // Verificando se o número de celular atende ao padrão
        return pattern.matcher(celular).matches();
    }
    
}
