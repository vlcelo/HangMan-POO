// Gerencia a seleção e validação de palavras
import java.util.*;

class WordManager {
    private List<String> words;
    private String currentWord;
    private Set<Character> guessedLetters;
    private StringBuilder displayedWord;
    private String lastWord = "";

    public WordManager(List<String> words) {
        this.words = new ArrayList<>(words);
        this.guessedLetters = new HashSet<>();
    }

    public void selectRandomWord() {
        if (words.isEmpty()) {
            System.err.println("Erro: Nenhuma palavra disponível.");
            currentWord = "";
            return;
        }
        Random random = new Random();
        String newWord;
        do {
            newWord = words.get(random.nextInt(words.size())).toUpperCase();
        } while (newWord.equals(lastWord) && words.size() > 1);
        lastWord = newWord;
        currentWord = newWord;
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
        StringBuilder spaced = new StringBuilder();
        for (int i = 0; i < displayedWord.length(); i++) {
            spaced.append(displayedWord.charAt(i)).append(" ");
        }
        return spaced.toString().trim();
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
