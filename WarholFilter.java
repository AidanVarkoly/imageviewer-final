import java.awt.Color;
/**
 * Write a description of class Warhol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarholFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;
    /**
     * Constructor for objects of class Warhol
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight() / 2;
        int width = image.getWidth() / 2;
        OFImage newImage = new OFImage(image.getWidth(), image.getHeight());
        OFImage original = new OFImage(image);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++)
            {
             image.setPixel(x,y, original.getPixel(x * 2, y * 2));   
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++)
            {
             image.setPixel(x + width, y, original.getPixel(x * 2, y * 2));   
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++)
            {
             image.setPixel(x + width, y + height, original.getPixel(x * 2, y * 2));   
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++)
            {
             image.setPixel(x , y + height, original.getPixel(x * 2, y * 2));   
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x , y);
                int Red = (pix.getRed());
                int Green = (pix.getGreen());
                int Blue = (pix.getBlue());
                image.setPixel(x , y, new Color(Red, Green , Blue));
            }
        }
       
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x , y);
                int Red = (pix.getRed());
                image.setPixel(x + width, y, new Color(Red, 0 , 0));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x , y);
                int Blue = (pix.getBlue());
                image.setPixel(x + width, y + height, new Color(0, 0 , Blue));
            }
        }
      
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x , y);
                int Green = (pix.getGreen());
                image.setPixel(x, y + height, new Color(0, Green , 0));
            }
        }
        image = image;
    }
}
