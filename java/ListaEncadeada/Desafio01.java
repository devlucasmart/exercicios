import java.util.*;

public class Desafio01 {
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final int MAX_SIZE = 300;

    public static void main(String[] args) {
        List<Integer> numeros = new LinkedList<>();

        try {
            Arrays.asList(1, 2, 3, 4, 5, -50, 8, 100, -100, 1, -50, 100)
                .forEach(num -> addNumero(numeros, num));

            // System.out.println("Iniciando teste de limite...");
            // testarLimiteDeTamanho(numeros);

            Set<Integer> numerosUnicos = new LinkedHashSet<>(numeros);
            List<Integer> numerosSemDuplicatas = new LinkedList<>(numerosUnicos);

            String resultado = numerosSemDuplicatas.stream()
                                                    .sorted()
                                                    .map(String::valueOf)
                                                    .reduce((a, b) -> a + ", " + b)
                                                    .orElse("");

            System.out.println("[" + resultado + "]");

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void addNumero(List<Integer> lista, int numero) {
        if (numero < MIN_VALUE || numero > MAX_VALUE) {
            throw new IllegalArgumentException("Número fora do intervalo permitido (" + MIN_VALUE + " a " + MAX_VALUE + "): " + numero);
        }
        if (lista.size() >= MAX_SIZE) {
            throw new IllegalStateException("Lista cheia, não é possível adicionar mais números.");
        }
        lista.add(numero);
    }

    public static void testarLimiteDeTamanho(List<Integer> lista) {
        Random random = new Random();

        for (int i = 0; i < 300; i++) {
                int numeroAleatorio = random.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
                addNumero(lista, numeroAleatorio);
            }
    }
}
