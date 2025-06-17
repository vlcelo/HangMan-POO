// Gerencia o ranking dos jogadores
import java.util.*;
class ScoreManager {
    private Map<String, Integer> scores;
    private GamePersistence persistence;
    private String scoreFilename;

    public ScoreManager(GamePersistence persistence, String scoreFilename) {
        this.persistence = persistence;
        this.scoreFilename = scoreFilename;
        this.scores = persistence.loadScores(scoreFilename); // Carrega ranking do arquivo ao iniciar
    }

    /**
     * Atualiza ou adiciona a pontuação de um jogador.
     * @param playerName Nome do jogador
     * @param points Pontuação a adicionar
     */
    public void updateScore(String playerName, int points) {
        scores.put(playerName, scores.getOrDefault(playerName, 0) + points);
        persistence.saveScores(scoreFilename, scores); // Salva após atualização
    }

    /**
     * Exibe o ranking atual dos jogadores ordenado por pontuação.
     */
    public void displayScores() {
        System.out.println("\n--- Ranking ---");

        if (scores.isEmpty()) {
            System.out.println("Nenhum ranking disponível ainda.");
        } else {
            scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " pontos")
                );
        }

        System.out.println("----------------\n");
    }
}