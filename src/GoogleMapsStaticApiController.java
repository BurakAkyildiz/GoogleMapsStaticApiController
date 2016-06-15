import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Google Maps Static Api kullanarak harita bilgileri alan sınıf.
 */
public class GoogleMapsStaticApiController
{
    //Google map api veriyolu.
    public static final String mapApiUrl = "https://maps.googleapis.com/maps/api/staticmap";
    
    /**
     * Google Static Map Api standartlarına uygun alınan verilerin harita image'ını döndüren metod.
     * Eğer bir harita resmi elde edemezse null değer döndürür.
     * @param center Arama Kelimeleri
     * @param zoom Harita kuşbakışı yükseklik değeri
     * @param imageWidth Istenilecek image için genişlik değeri.
     * @param imageHeight Istenilecek image için yükseklik değeri.
     * @param mapType Istenilecek haritanın tipi
     * @return Talep edilen harita resmi.
     */
    public static Image getMapImage(String center,int zoom,String imageWidth,String imageHeight,String mapType)
    {
        Image img = null;
        try {
            URL u = new URL("https://maps.googleapis.com/maps/api/staticmap?center="+center+"&zoom="+zoom+"&size="+imageWidth+"x"+imageHeight+"&maptype="+mapType+"&format=jpg");
            img = new ImageIcon(u).getImage();
        }
        catch (Exception ex) {System.err.println("Google Static Api connection exception : "+ex.getMessage());}
        return img;
    }
    
}
