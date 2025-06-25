import java.io.*;
import java.util.*;

public class HangmanGame extends Game implements GamePersistence {
    private Player currentPlayer;
    private WordManager wordManager;
    private ScoreManager scoreManager;
    private int remainingAttempts;

    private final String wordsFilename = "palavras.txt";
    private final String scoresFilename = "ranking.txt";

    public HangmanGame(Player player) {
        super("Jogo da Forca", 6);
        this.currentPlayer = player;

        List<String> initialWords = loadWords(wordsFilename);
        if (initialWords.isEmpty()) {
            System.out.println("Arquivo de palavras nao encontrado ou vazio. Usando palavras padrao.");
            initialWords.addAll(Arrays.asList("PROGRAMACAO", "ORIENTADA", "OBJETOS", "JAVASCRIPT", "COMPUTADOR"));
            try (FileWriter writer = new FileWriter(wordsFilename)) {
                for (String word : initialWords) {
                    writer.write(word + System.lineSeparator());
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar palavras padrao: " + e.getMessage());
            }
        }

        this.wordManager = new WordManager(initialWords);
        this.scoreManager = new ScoreManager(this, scoresFilename);
    }

    @Override
    public void startGame() {
        System.out.println("\n--- INICIO DA NOVA RODADA ---");
        System.out.println("Bem-vindo ao " + gameName + ", " + currentPlayer.getName() + "!");
        remainingAttempts = maxAttempts;
        gameEnded = false;
        wordManager.selectRandomWord();
        System.out.println("Categoria da palavra: " + wordManager.getCurrentCategory());
    }

    @Override
    public boolean makeGuess(String guess) {
        if (gameEnded) {
            System.out.println("O jogo ja terminou. Por favor, inicie uma nova rodada.");
            return false;
        }

        if (guess == null || guess.isEmpty()) {
            System.out.println("Palpite invalido. Tente novamente.");
            return false;
        }

        guess = guess.toUpperCase();

        if (guess.length() == 1) {
            char letter = guess.charAt(0);
            if (!Character.isLetter(letter)) {
                System.out.println("Insira uma letra valida.");
                return false;
            }

            if (wordManager.getGuessedLetters().contains(letter)) {
                System.out.println("Voce ja tentou a letra '" + letter + "'.");
                return false;
            }

            if (wordManager.revealLetter(letter)) {
                System.out.println("Acertou! A letra '" + letter + "' esta na palavra.");
                currentPlayer.addScore(10);
            } else {
                System.out.println("Errou! A letra '" + letter + "' nao esta na palavra.");
                remainingAttempts--;
            }
        } else {
            if (guess.equals(wordManager.getCurrentWord())) {
                System.out.println("Parabens! Voce acertou a palavra completa!");
                for (int i = 0; i < wordManager.getCurrentWord().length(); i++) {
                    wordManager.revealLetter(wordManager.getCurrentWord().charAt(i));
                }
                currentPlayer.addScore(50);
                gameEnded = true;
            } else {
                System.out.println("Palpite incorreto.");
                remainingAttempts -= 2;
            }
        }

        checkGameStatus();
        return true;
    }

    private void checkGameStatus() {
        if (wordManager.isWordGuessed() && !gameEnded) {
            System.out.println("\nParabens! Voce adivinhou a palavra: " + wordManager.getCurrentWord());
            gameEnded = true;
        } else if (remainingAttempts <= 0) {
            System.out.println("\nGame Over! A palavra era: " + wordManager.getCurrentWord());
            gameEnded = true;
        }

        if (gameEnded) {
            scoreManager.updateScore(currentPlayer.getName(), currentPlayer.getScore());
            System.out.println("Pontuacao final nesta rodada: " + currentPlayer.getScore() + " pontos.");
        }
    }

    @Override
    public void displayGameState() {
        System.out.println("\nPalavra: " + wordManager.getDisplayedWord());
        System.out.println("Tentativas restantes: " + remainingAttempts);
        System.out.println("Letras tentadas: " + wordManager.getGuessedLetters());
        System.out.println("Pontuacao: " + currentPlayer.getScore());
    }

    private void displayHangmanState() {
        switch (remainingAttempts) {
            case 6:
                System.out.println("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
                break;
            case 5:
                System.out.println("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
                break;
            case 4:
                System.out.println("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
                break;
            case 3:
                System.out.println("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
                break;
            case 2:
                System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
                break;
            case 1:
                System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
                break;
            case 0:
                System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");
                break;
        }
    }

    @Override
    public List<String> loadWords(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim().toUpperCase());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar palavras: " + e.getMessage());
        }
        return words;
    }

    @Override
    public void saveScores(String filename, Map<String, Integer> scores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar ranking: " + e.getMessage());
        }
    }

    @Override
    public Map<String, Integer> loadScores(String filename) {
        Map<String, Integer> scores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    scores.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar ranking: " + e.getMessage());
        }
        return scores;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        HangmanGame game = new HangmanGame(player);

        String resposta;
        do {
            game.startGame();
            while (!game.hasGameEnded()) {
                game.displayHangmanState();
                game.displayGameState();
                System.out.print("\nAdivinhe uma letra ou a palavra completa: ");
                String guess = scanner.nextLine();
                game.makeGuess(guess);
            }

            System.out.println("\n=== FIM DA RODADA ===");
            game.scoreManager.displayScores();

            System.out.print("Deseja jogar novamente? (s/n): ");
            resposta = scanner.nextLine().trim().toLowerCase();
        } while (resposta.equals("s"));

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
}
