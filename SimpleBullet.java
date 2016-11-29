package cs12mariomp;
import java.awt.*;
 import java.awt.image.*;
 import java.io.InputStream;

 public class SimpleBullet extends GameObject {
     int x, y;
     InputStream picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet1.png");
     BufferedImage img;
     BufferedImage i1 = MarioWindow.getImage(picture_input_stream);
     boolean appear = false;
     String direction;
     HeroGameThread hgt;

     public SimpleBullet(HeroGameThread hgt) {
         img = i1;
         this.hgt = hgt;
         this.x = hgt.getX();
         this.y = hgt.getY();
         hgt.setSimpleBullet(this);
     }

     public void setX(int x) {
         this.x = x;
     }

     public void setY(int y) {
         this.y = y;
     }

     public void paint(Graphics2D g2d) {
         if (img != null && appear == true) {
             g2d.drawImage(img,x,y, 200, 300, null);
         } else if (appear == true){
             g2d.fillArc(x,y,10,10,0,360);
         }
     }

     public void run() {
         while(true) {
             if (appear == true) {
                 if (direction.equals("left")) {
                     x = x - 20;
                 }
                 else {
                     x = x + 20;
                 }
                 //appear = false;
             }
             Point p = new Point(x + 150, y);
             hgt.setSimpleBulletPoint(p);
             MarioWindow.delay(100);
         }
     }


     public void keyPressed(String key) {

         if (key.equals("R")) {
             direction = hgt.getToWhereFacing();
             if (direction.equals("left")) {
                 x = x - 100;
             }

             else {
                 x = x + 150;
             }

             MarioWindow.delay(20);
             appear = true;
             while (hgt.bulletToZombieXDistance() < 210) { //210 is the horizontal acceptable distance of a hit
                 picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet2.png");
                 MarioWindow.delay(300);
                 img = MarioWindow.getImage(picture_input_stream);
                 picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet3.png");
                 MarioWindow.delay(300);
                 img = MarioWindow.getImage(picture_input_stream);
                 picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet4.png");
                 MarioWindow.delay(300);
                 img = MarioWindow.getImage(picture_input_stream);
            }
             picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_end_simple_bullet.png");
             MarioWindow.delay(200);
             img = MarioWindow.getImage(picture_input_stream);
             appear = false;

         }

     }
 }
