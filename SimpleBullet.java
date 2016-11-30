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
     SimpleBulletSkillThread sb_skill;

     public SimpleBullet(HeroGameThread hgt, SimpleBulletSkillThread sb_skill) {
         img = i1;
         this.hgt = hgt;
         this.x = hgt.getX();
         this.y = hgt.getY();
         this.sb_skill = sb_skill;
         sb_skill.setSimpleBullet(this);

     }

     public void setX(int x) {
         this.x = x;
     }

     public void setY(int y) {
         this.y = y;
     }

     public void setAppear(boolean appear) {
         this.appear = appear;
     }

     public void setImg(BufferedImage img) {
         this.img = img;
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
             Point p = new Point(x + 150, y + 100);
             sb_skill.setSimpleBulletPoint(p);
            // System.out.println("Naset naman bullet point ng sb_skill");
             MarioWindow.delay(100);
         }
     }


     public void keyPressed(String key) {

         if (key.equals("R")) {
             direction = hgt.getToWhereFacing();
             setX(hgt.getX());
             setY(hgt.getY());
             if (direction.equals("left")) {
                 x = x - 100;
             }

             else {
                 x = x + 150;
             }

             MarioWindow.delay(20);
            appear = true;

             sb_skill.setBulletLoopReady();
         }

     }
 }
