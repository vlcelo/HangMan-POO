import java.util.*;

class WordManager {
    private Map<String, List<String>> categorizedWords = new HashMap<>();
    private String currentWord;
    private String currentCategory;
    private Set<Character> guessedLetters;
    private StringBuilder displayedWord;
    private String lastWord = "";

    public WordManager(List<String> lines) {
        this.guessedLetters = new HashSet<>();
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                String category = parts[0].trim().toUpperCase();
                String word = parts[1].trim().toUpperCase();
                categorizedWords.computeIfAbsent(category, k -> new ArrayList<>()).add(word);
            }
        }
    }

    public void selectRandomWord() {
        List<String> categories = new ArrayList<>(categorizedWords.keySet());
        if (categories.isEmpty()) {
            System.err.println("Erro: Nenhuma palavra com categoria disponível.");
            currentWord = "";
            currentCategory = "INDEFINIDA";
            return;
        }

        Random random = new Random();
        String category;
        String word;

        do {
            category = categories.get(random.nextInt(categories.size()));
            List<String> words = categorizedWords.get(category);
            word = words.get(random.nextInt(words.size()));
        } while (word.equals(lastWord) && categorizedWords.values().stream().mapToInt(List::size).sum() > 1);

        lastWord = word;
        currentWord = word;
        currentCategory = category;
        displayedWord = new StringBuilder(currentWord.length());
        for (int i = 0; i < currentWord.length(); i++) {
            displayedWord.append('_');
        }
        guessedLetters.clear();
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String getCurrentCategory() {
        return currentCategory;
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
