// Gerencia a seleção e validação de palavras
import java.util.*;

class WordManager {
    private List<String> words;
    private String currentWord;
    private Set<Character> guessedLetters;
    private StringBuilder displayedWord;

    public WordManager(List<String> words) {
        this.words = words;
        this.guessedLetters = new HashSet<>();
    }

    public void selectRandomWord() {
        if (words.isEmpty()) {
            System.err.println("Erro: Nenhuma palavra disponível.");
            currentWord = "";
            return;
        }
        Random random = new Random();
        currentWord = words.get(random.nextInt(words.size())).toUpperCase();
        displayedWord = new StringBuilder(currentWord.length());
        for (int i = 0; i < currentWord.length(); i++) {
            displayedWord.append('_');
        }
        guessedLetters.clear();
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public String getDisplayedWord() {
        return displayedWord.toString();
    }

    public boolean revealLetter(char letter) {
        boolean found = false;
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == letter) {
                    displayedWord.setCharAt(i, letter);
                    found = true;
                }
            }
        }
        return found;
    }

    public boolean isWordGuessed() {
        return displayedWord.indexOf("_") == -1;
    }
}
