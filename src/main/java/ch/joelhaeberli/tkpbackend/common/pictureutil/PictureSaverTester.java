package ch.joelhaeberli.tkpbackend.common.pictureutil;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PictureSaverTester {

    public static void main(String[] args) throws Base64DecodingException {

        System.out.println("USERHOME : " + System.getProperty("user.home"));

        // Save from buffered image
        String name = PictureHandler.savePicture(createImageWithText());
        // Save from byte array
        String name2 = PictureHandler.savePicture(createImageWithTextAsByteArray());

        System.out.println("Saved Picture 01 : " + name);
        System.out.println("Saved Picture 02 : " + name2);

        // Read from disk and save to disk
        BufferedImage bufferedImage1 = PictureHandler.getBufferedImageFromDisk(name2);
        String name3 = PictureHandler.savePicture(bufferedImage1);

        System.out.println("Saved Picture 03 : " + name3);

        // Create Thumbnail from Picture
       // BufferedImage bufferedImage = PictureHandler.getThumbnailFromImage(name3);
       // String thumbnail = PictureHandler.savePicture(bufferedImage);

      //  System.out.println("Saved Thumbnail : " + thumbnail);
    }

    private static BufferedImage createImageWithText(){
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.drawString("www.tutorialspoint.com", 20,20);
        g.drawString("www.tutorialspoint.com", 20,40);
        g.drawString("www.tutorialspoint.com", 20,60);
        g.drawString("www.tutorialspoint.com", 20,80);
        g.drawString("www.tutorialspoint.com", 20,100);

        return bufferedImage;
    }

    private static byte[] createImageWithTextAsByteArray() throws Base64DecodingException {
        return Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAIAAAAiOjnJAAACfUlEQVR42u3a3Y7qIBgFUN7/pTvJXBgj/59WwKx1cZKjVVrZg5XslAAAAAAAAL7jui4fggmO5KD9kk8Fq/s+EvxrwdpkvgWr+olc//IHw88+D/GQH/N4PD/s+cGXE35+VW2U9rMvgxZPuPg++QHFodtv2L20xukJVvUPuhis7mH58d3hxs+5FvrBK23MffujGzyl87J1ULBelqhYsLqn1B505FUj35LdSxu5zAOClf/7/rOfDVZtiOL3USMlsxH5QrAan+3Z93DtVfedZ7+5YrW/wsLvY8XaLliziRm/xwoEKz/J8D3W4Do3eBfRfVCwWsGq/bf2M3DkB9rUV+FnfxWO/IW0r6J7ab8QLFtrIFgIFgAAAAAMsVllgoM50HkXrAULjM77+inXee8OmnTetwpW0nnXed85WDrv5wVL513n/ZZs6bxbsY4Jls574B5LsOaClXTedd5trYFgIVgAAAAAUGazygQHc6DzLlgLFhid9/VTrvPeHTTpvG8VrKTzrvO+c7B03s8Lls67zvst2dJ5t2IdEyyd98A9lmDNBSvpvOu821oDwUKwAAAAAKDMZpUJDuZA512wFiwwOu/rp1znvTto0nnfKlhJ513nfedg6byfFyydd533W7Kl827FOiZYOu+BeyzBmgtW0nnXebe1BoKFYAEAAABAmc0qExzMgc67YC1YYHTe10+5znt30KTzvlWwks67zvvOwdJ5Py9YOu8677dkS+fdinVMsHTeA/dYgjUXrKTzrvNuaw0EC8ECAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAID9/QETNnusDskpBgAAAABJRU5ErkJggg==");
    }
}
