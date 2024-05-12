import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    String nome;
    String especie;
    String raca;
    LocalDateTime dataCadastro;

    public Animal(String nome, String especie, String raca) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataCadastro = LocalDateTime.now();
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataCadastro.format(formatter);
        return "Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca + ", Data de Cadastro: " + dataFormatada;
    }
}

class Petshop {
    static ArrayList<Animal> animais = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Registrar entrada de animal");
            System.out.println("2. Registrar saída de animal");
            System.out.println("3. Listar animais");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    registrarEntrada(scanner);
                    break;
                case 2:
                    registrarSaida(scanner);
                    break;
                case 3:
                    listarAnimais();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    static void registrarEntrada(Scanner scanner) {
        System.out.println("Digite o nome do animal:");
        String nome = scanner.nextLine();
        System.out.println("Digite a espécie do animal:");
        String especie = scanner.nextLine();
        System.out.println("Digite a raça do animal:");
        String raca = scanner.nextLine();
        Animal animal = new Animal(nome, especie, raca);
        animais.add(animal);
        System.out.println("Animal registrado com sucesso");
    }

    static void registrarSaida(Scanner scanner) {
        System.out.println("Digite o nome do animal a ser removido:");
        String nome = scanner.nextLine();
        boolean removido = animais.removeIf(animal -> animal.nome.equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Animal removido com sucesso");
        } else {
            System.out.println("Animal não encontrado");
        }
    }

    static void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado");
        } else {
            System.out.println("Animais cadastrados:");
            for (Animal animal : animais) {
                System.out.println(animal);
            }
        }
    }
}