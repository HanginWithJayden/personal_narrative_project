import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    String[][] food = {
      {"Eggs", "Bacon", "Waffle"},
      {"Beef", "Tortilla", "Lettuce"},
      {"Chicken", "Baked beans", "Mac & cheese"}
    };

    MyStory scene = new MyStory(food);

    scene.drawScene();
    
    Theater.playScenes(scene);
        
  }
}