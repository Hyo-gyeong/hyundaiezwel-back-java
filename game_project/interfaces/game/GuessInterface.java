package game_project.interfaces.game;

public interface GuessInterface {
  static int number = (int) (Math.random()*10) +1;
  public void gameStart();
}
