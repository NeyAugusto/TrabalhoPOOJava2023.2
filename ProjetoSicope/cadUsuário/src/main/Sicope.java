package main;

import cadastro.Cadastro;
import consulta.Consulta;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Classe principal que contém o método main
class Sicope {
    private static Scanner ler = new Scanner(System.in);
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {
        try {
            while (true) {
				exibirOpcoes();
                int opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        cadastrarUsuario();
                        break;

                    case 2:
                        marcarConsulta();
                        break;

                    case 3:
                        exibirInformacoesUsuarios();
                        break;

                    case 4:
                        exibirConsultas();
                        break;

                    case 5:
						editarUsuario();
						break;
					
					case 6:
						excluirUsuario();
						break;
					
					case 7:
						System.out.println("Término do Agendamento, Estimamos Melhoras à Você !!!!");
						return;
						
                }
            }
        } finally {
            ler.close();
        }
    }
	
	// Métodos auxiliares para manipulação do sistema
    private static void exibirOpcoes() {
		System.out.println("Escolha uma opção: \n" +
            "1. Cadastrar Usuario \n" +
            "2. Marcar Consulta \n" +
            "3. Exibir Informação dos Usuários Cadastrados \n" +
            "4. Exibir Consultas \n" +
            "5. Editar Usuário \n" +
            "6. Excluir Usuário \n" + 
            "7. Sair \n");
    }

    private static void cadastrarUsuario() {
		Usuario usuario = new Usuario();
        System.out.print("Nome do Usuário: \n");
        usuario.setNome(ler.nextLine());
        System.out.print("CPF do Usuário: \n");
        usuario.setCpf(ler.nextLine());

		// Validar o CPF antes de prosseguir
		if (!usuario.validarcpf()) {
			System.out.println("CPF inválido. Usuário não cadastrado.");
			return;
		}

        Cadastro cadastro = new Cadastro();
        // Preencher os dados do cadastro...
		System.out.print("Endereço do Usuário: \n");
        cadastro.setEndereco(ler.nextLine());
        System.out.print("Municipio onde Reside o Usuário: \n");
        cadastro.setMunicipio(ler.nextLine());
        System.out.print("Celular do Usuário: \n");
        cadastro.setCelular(ler.nextLine());
		
        // Atribuir o número de celular ao cadastro antes de validar
        if (!cadastro.validarCelular()) {
            System.out.println("Número de celular inválido. Usuário não cadastrado.");
            return;
        }
        
        System.out.print("Qual sua Identidade de Gênero: \n");
        cadastro.setGenero(ler.nextLine());
		System.out.print("Idade: ");
        int idade = ler.nextInt();

        // Validar a idade antes de atribuir ao cadastro
        if (cadastro.validarIdade(idade)) {
            cadastro.setIdade(idade);
            usuario.setCadastro(cadastro);
            usuarios.add(usuario);
        } else {
            System.out.println("Idade inválida. Usuário não cadastrado.");
}
    }

    private static void marcarConsulta() {
        Consulta novaConsulta = new Consulta();

        System.out.print("Nome do Usuário: \n");
        novaConsulta.setUsuario(ler.nextLine());
        System.out.print("Especialidade da Consulta: \n");
        novaConsulta.setEspecialidade(ler.nextLine());
        System.out.print("Dia da Consulta (dd/MM/yyyy): \n");
        novaConsulta.setDia(ler.nextLine());
        System.out.print("Horário da Consulta (HH:mm): \n");
        novaConsulta.setHorario(ler.nextLine());

        if (novaConsulta.validarData() && novaConsulta.validarHora()) {
            consultas.add(novaConsulta);
        } else {
            System.out.println("Data ou hora inválida. Consulta não marcada.");
        }
    }

    private static void editarUsuario() {
        // ... (código não modificado)
		System.out.println("Digite o nome ou CPF do usuário que deseja editar: ");
    String busca = ler.nextLine();

    // Buscar o usuário na lista
    Usuario usuarioParaEditar = null;
    for (Usuario u : usuarios) {
        if (u.getNome().equalsIgnoreCase(busca) || u.getCpf().equals(busca)) {
            usuarioParaEditar = u;
            break;
        }
    }

    if (usuarioParaEditar != null) {
        // Exibir as informações do usuário antes da edição
        System.out.println("Informações do usuário antes da edição:");
        usuarioParaEditar.exibirInformacoes();

        // Solicitar as novas informações
        System.out.println("Digite as novas informações:");

        System.out.print("Nome do Usuário: ");
        usuarioParaEditar.setNome(ler.nextLine());

        System.out.print("CPF do Usuário: ");
        usuarioParaEditar.setCpf(ler.nextLine());

        // Validar o CPF antes de prosseguir
        if (!usuarioParaEditar.validarcpf()) {
            System.out.println("CPF inválido. Edição cancelada.");
            return;
        }

        Cadastro cadastro = usuarioParaEditar.getCadastro();
        System.out.print("Endereço do Usuário: ");
        cadastro.setEndereco(ler.nextLine());

        System.out.print("Municipio onde Reside o Usuário: ");
        cadastro.setMunicipio(ler.nextLine());

        System.out.print("Celular do Usuário: ");
        cadastro.setCelular(ler.nextLine());

        // Atribuir o número de celular ao cadastro antes de validar
        if (!cadastro.validarCelular()) {
            System.out.println("Número de celular inválido. Edição cancelada.");
            return;
        }

        System.out.print("Qual sua Identidade de Gênero: ");
        cadastro.setGenero(ler.nextLine());

        System.out.print("Idade: ");
        cadastro.setIdade(ler.nextInt());

        // Validar a idade antes de prosseguir
        if (!cadastro.validarIdade()) {
            System.out.println("Idade inválida. Edição cancelada.");
            return;
        }

        // Exibir as informações do usuário após a edição
        System.out.println("Informações do usuário após a edição:");
        usuarioParaEditar.exibirInformacoes();
    } else {
        System.out.println("Usuário não encontrado.");
    }

}

	private static void excluirUsuario() {
		System.out.println("Digite o nome ou CPF do usuário que deseja excluir: ");
		String busca = ler.nextLine();
	
		// Buscar o usuário na lista
		Usuario usuarioParaExcluir = null;
		for (Usuario u : usuarios) {
			if (u.getNome().equalsIgnoreCase(busca) || u.getCpf().equals(busca)) {
				usuarioParaExcluir = u;
				break;
			}
		}
	
		if (usuarioParaExcluir != null) {
			// Exibir as informações do usuário antes da exclusão
			System.out.println("Informações do usuário antes da exclusão:");
			usuarioParaExcluir.exibirInformacoes();
	
			// Confirmar a exclusão
			System.out.println("Deseja realmente excluir este usuário? (S/N)");
			String confirmacao = ler.nextLine().toUpperCase();
	
			if (confirmacao.equals("S")) {
				usuarios.remove(usuarioParaExcluir);
				System.out.println("Usuário excluído com sucesso.");
			} else {
				System.out.println("Exclusão cancelada.");
			}
		} else {
			System.out.println("Usuário não encontrado.");
		}
}


    private static void exibirInformacoesUsuarios() {
		Collections.sort(usuarios);
        for (Usuario u : usuarios) {
            u.exibirInformacoes();
        }
    }

    private static void exibirConsultas() {
		for (Consulta c : consultas) {
            System.out.println(c);
        }
    }

}
