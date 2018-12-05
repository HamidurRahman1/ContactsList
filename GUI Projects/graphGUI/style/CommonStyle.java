package graphGUI.style;

public class CommonStyle
{
    public static String FontFamily()
    {
        return "-fx-font-family: Monaco;";
    }
    
    public static String FontSize()
    {
        return "-fx-font-size: 15;";
    }
    
    public static String FontWeight()
    {
        return "-fx-font-weight: bold;";
    }
    
    public static String Fm_Fs_Fw()
    {
        return FontFamily().concat(FontSize()).concat(FontWeight());
    }
    
    public static String LabelStyle()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("-fx-text-fill: crimson;")
          .append("-fx-font-size: 18;").append(FontWeight());
        return sb.toString();
    }
    
    public static String RadioButtonCSS()
    {
        return Fm_Fs_Fw().concat(Pad_Hei_Wei());
    }
    
    public static String RandomGraphCSS()
    {
        return CommonStyle.Fm_Fs_Fw().concat(Pad_Hei_Wei())
                          .concat("-fx-background-color: green;").concat("-fx-text-fill: white;");
    }
    
    public static String DeleteGraphCSS()
    {
        return CommonStyle.Fm_Fs_Fw().concat("-fx-background-color: #990000;")
                          .concat("-fx-text-fill: white;").concat(Pad_Hei_Wei());
    }
    
    public static String ButtonCSS()
    {
        return CommonStyle.Fm_Fs_Fw().concat(Pad_Hei_Wei());
    }
    
    public static String Pad_Hei_Wei()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("-fx-border-insets: 7 7 7 7;")
          .append("-fx-pref-width: 185;")
          .append("-fx-pref-height: 35;");
        
        return sb.toString();
    }
    
    public static String VBoxCSS()
    {
        return CommonStyle.FontFamily().concat("-fx-font-size: 18;")
                          .concat("-fx-border-color: black;").concat("-fx-padding: 7;");
    }
}
