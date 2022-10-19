import java.awt.*;

class TV56{
    private int size;
    public TV56(int n){
        size = n;
    }
}

class ColorTV extends TV56{
    private int colors;
    public ColorTV(int colors, int size){
        super(size);
        this.colors = colors;
    }
}
public class Practice_5_6 {
}
