package consulta;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Classe Consulta representa uma consulta médica agendada
public class Consulta {
    private String usuario = "";
    private String especialidade;
    private String dia;
    private String horario;

    public Consulta() {
    }

    public Consulta(String usuario, String especialidade, String dia, String horario) {
        this.usuario = usuario;
        this.especialidade = especialidade;
        this.dia = dia;
        this.horario = horario;
    }

    // Getter e Setter para cada atributo
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

	// Métodos para validar data e hora
    public boolean validarData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            java.util.Date dataConsulta = dateFormat.parse(this.dia);
            Date dataAtual = new Date(0);

            // Verifica se a data da consulta é no futuro
            return dataConsulta.after(dataAtual);
        } catch (ParseException e) {
            return false; // Formato de data inválido
        }
    }
	
    public boolean validarHora() {
        String regexHora = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        return this.horario.matches(regexHora);
    }
	
	// Método para exibir informações da consulta
    public void exibirInformacoes() {
        System.out.println("Consulta agendada para: ");
        System.out.println("Usuário: " + usuario);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Data: " + dia);
        System.out.println("Horário: " + horario);
    }

    @Override
    public String toString() {
        return "Consulta [\n" +
               "  usuario=" + usuario + ",\n" +
               "  especialidade=" + especialidade + ",\n" +
               "  dia=" + dia + ",\n" +
               "  horario=" + horario + "\n" +
               "]";
    }
    
}
