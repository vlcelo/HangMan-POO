// Interface para persistência de dados do jogo
import java.util.List;
import java.util.Map;

interface GamePersistence {
    List<String> loadWords(String filename);
    void saveScores(String filename, Map<String, Integer> scores);
    Map<String, Integer> loadScores(String filename);
}
