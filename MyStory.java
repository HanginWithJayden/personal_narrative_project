import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] ingredients; 
  private String[] names = {
    "Breakfast",
    "Lunch",
    "Dinner" 
  };
  
  // Constructor
  public MyStory(String[][] ingredients) {
    this.ingredients = ingredients;
  }

  // Main drawScene Method
  public void drawScene() {
    drawIntroScene();
    drawBreakfastScene();
    drawLunchScene();
    drawDinnerScene();
    drawOutroScene();
  }

  // ... other methods ...

  public void drawIntroScene() {
    clear("white");
    drawImage("channels4_profile.jpg", 100, 100, 175);
    setTextStyle(Font.SANS, FontStyle.BOLD_ITALIC);
    setTextHeight(25);
    setTextColor("black");
    drawText("Recipes to Go", 100, 50);
    drawText("Throughout the Day", 62, 75);
    drawText("By: Jayden M. Haynes", 50, 325);
    pause(2.5);
  }
  
  public void drawBreakfastScene() {
    // 1. Clear the scene OR draw the background
    playSound("pageflip1.wav");
    clear("white");
    
    // 2. Set the text styles (size, color, font)
    setTextStyle(Font.SANS, FontStyle.BOLD_ITALIC);
    setTextHeight(25);
    setTextColor("black");
    
    // 3. Draw text/images on the scene
    ImageFilter breakfast = new ImageFilter("breakfast.jpg");
    drawImage(breakfast, 0, 0, 400);
    breakfast.applyBlur();
    pause(2.5);
    drawImage(breakfast, 0, 0, 400);

    drawText("Waffle Breakfast Combo", 25, 50);
    drawText("Meal contains:", 25, 100);
    pause(0.5);

    String[] breakfastRow = ingredients[0];
    int y = 150;
    for (int i = 0; i < breakfastRow.length; i++) {
      drawText(breakfastRow[i], 50, y);
      y += 50;
      pause(2.5);
    }
    
    // 4. Play sounds and/or pause

  }

  public void drawLunchScene() {
    // 1. Clear the scene OR draw the background
    playSound("pageflip1.wav");
    clear("white");
    
    // 2. Set the text styles (size, color, font)
    setTextStyle(Font.SANS, FontStyle.BOLD_ITALIC);
    setTextHeight(25);
    setTextColor("white");
    
    // 3. Draw text/images on the scene
    ImageFilter lunch = new ImageFilter("lunch.png");
    drawImage(lunch, 0, 0, 400);
    lunch.applyBlur();
    pause(2.5);
    drawImage(lunch, 0, 0, 400);

    drawText("Tortilla Taco", 25, 50);
    drawText("Meal contains:", 25, 100);
    pause(0.5);

    String[] lunchRow = ingredients[1];
    int y = 150;
    for (int i = 0; i < lunchRow.length; i++) {
      drawText(lunchRow[i], 50, y);
      y += 50;
      pause(2.5);
    }
  }

  public void drawDinnerScene() {
    playSound("pageflip1.wav");
    // 1. Clear the scene OR draw the background
    clear("white");
    
    // 2. Set the text styles (size, color, font)
    setTextStyle(Font.SANS, FontStyle.BOLD_ITALIC);
    setTextHeight(25);
    setTextColor("white");
    
    // 3. Draw text/images on the scene
    ImageFilter dinner = new ImageFilter("dinner.png");
    drawImage(dinner, 0, 0, 400);
    dinner.applyBlur();
    pause(2.5);
    drawImage(dinner, 0, 0, 400);

    drawText("Soul Food Meal", 25, 50);
    drawText("Meal contains:", 25, 100);
    pause(0.5);

    String[] dinnerRow = ingredients[2];
    int y = 150;
    for (int i = 0; i < dinnerRow.length; i++) {
      drawText(dinnerRow[i], 50, y);
      y += 50;
      pause(2.5);
    }
  }

  public void drawOutroScene() {
    clear("white");
    setTextStyle(Font.SANS, FontStyle.BOLD_ITALIC);
    setTextHeight(50);
    setTextColor("black");
    drawText("Thanks for", 75, 150);
    drawText("reading!", 100, 200);
  }
  
}