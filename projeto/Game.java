// Classe abstrata para definir a estrutura básica de um jogo
abstract class Game {
    protected String gameName;
    protected int maxAttempts;
    protected boolean gameEnded;

    public Game(String gameName, int maxAttempts) {
        this.gameName = gameName;
        this.maxAttempts = maxAttempts;
        this.gameEnded = false;
    }

    public abstract void startGame();
    public abstract boolean makeGuess(String guess);
    public boolean hasGameEnded() {
        return gameEnded;
    }
    public abstract void displayGameState();
    public String getGameName() {
        return gameName;
    }
}
