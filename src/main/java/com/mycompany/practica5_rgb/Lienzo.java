/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica5_rgb;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Lienzo extends JPanel{
    
    private BufferedImage image = null;
    private BufferedImage logo = null;
    private boolean c_red = true;
    private boolean c_green = true;
    private boolean c_blue = true;
    private int posx_logo = 0;
    private int posy_logo = 0;
    public Lienzo() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        try {
            image = ImageIO.read(new URL("https://www.ociolaspalmas.com/wp-content/uploads/2013/04/11.jpg"));
            logo = ImageIO.read(new URL("https://www.abroadweekenders.com/wp-content/uploads/2020/02/CARNAVAL-2-300x150.png"));
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageFiltered(c_red,c_green,c_blue), 0, 0, null);
        g.drawImage(logo, posx_logo, posy_logo, null);
    }
    
    public void setRed(boolean c_red){
        this.c_red = c_red;
    }
    public void setGreen(boolean c_green){
        this.c_green = c_green;
    }
    public void setBlue(boolean c_blue){
        this.c_blue = c_blue;
    }
    
    public BufferedImage imageFiltered(boolean c_red, boolean c_green, boolean c_blue){
        return UtilsPractica5.seleccionarComponentes(image,c_red,c_green,c_blue);
    }
    
    public void setPosxLogo(int posx_logo){
        this.posx_logo = posx_logo;
    }
    
    public void setPosyLogo(int posy_logo){
        this.posy_logo = posy_logo;
    }
}
