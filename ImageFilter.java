import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }

  public void adjustContrast(int multiplier) {

    Pixel[][] pixels = getImagePixels();
    
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        int newRed = currentPixel.getRed() * multiplier;
        if (newRed > 255) {
          newRed = 255;
        }
        currentPixel.setRed(newRed);
        int newBlue = currentPixel.getBlue() * multiplier;
        if (newBlue > 255) {
          newBlue = 255;
        }
        currentPixel.setBlue(newBlue);
        int newGreen = currentPixel.getGreen() * multiplier;
        if (newGreen > 255) {
          newGreen = 255;
        }
        currentPixel.setGreen(newGreen);
      }
    }
  }

  public void applyBlur() {

    Pixel[][] pixels = getImagePixels();

    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];
        int red = calcWeightedRed(pixels, row, col);
        int green = calcWeightedGreen(pixels, row, col);
        int blue = calcWeightedBlue(pixels, row, col);
        currentPixel.setRed(red);
        currentPixel.setGreen(green);
        currentPixel.setBlue(blue);
      }
    }
  }

  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }
  
}