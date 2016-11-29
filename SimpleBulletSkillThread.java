package cs12mariomp;
import java.awt.image.*;
import java.io.InputStream;
class SimpleBulletSkillThread extends GameObject{
        private SimpleBullet simple_bullet;
        private ZombiePila zombie_pila;
        private Hero hero;
        private Point simple_bullet_point;
        private boolean bullet_loop_ready = false;
        InputStream picture_input_stream;
        BufferedImage img;

        public SimpleBulletSkillThread (ZombiePila zombie_pila, Hero hero) {
            this.zombie_pila = zombie_pila;
            this.hero = hero;
        }

        public void setSimpleBullet(SimpleBullet simple_bullet) {
            this.simple_bullet = simple_bullet;
        }

        public void setSimpleBulletPoint(Point simple_bullet_point) {
            this.simple_bullet_point = simple_bullet_point;
        }

        public void setBulletLoopReady() {
            bullet_loop_ready = true;
        }

        public void run() {
            while (true) {
                MarioWindow.delay(20);
                if (bullet_loop_ready == true) {
                    bulletLoop();
                }
            }
        }

        public void bulletLoop(){
            while (bulletToZombieInAction() == true) { //210 is the horizontal acceptable distance of a hit
                picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet2.png");
                MarioWindow.delay(300);
                img = MarioWindow.getImage(picture_input_stream);
                simple_bullet.setImg(img);
                picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet3.png");
                MarioWindow.delay(300);
                img = MarioWindow.getImage(picture_input_stream);
                simple_bullet.setImg(img);
                picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_simple_bullet4.png");
                MarioWindow.delay(300);
                img = MarioWindow.getImage(picture_input_stream);
                simple_bullet.setImg(img);
           }
           //System.out.println("Did not Entered loop");
           picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_end_simple_bullet.png");
           img = MarioWindow.getImage(picture_input_stream);
           simple_bullet.setImg(img);
           MarioWindow.delay(500);
           simple_bullet.setAppear(false);
           setSimpleBulletPoint(null);
           bullet_loop_ready = false;
        }

        public boolean bulletToZombieInAction() {
            if (simple_bullet_point != null) {
                for (NodeZombie rover = zombie_pila.head; rover != null && simple_bullet_point.getX() < 1900; rover = rover.next) {
                    Point zombie_location = rover.zombie.getZGT().getPointCM();
                    zombie_location.sayHello();
                    if (Math.abs(simple_bullet_point.getY() - zombie_location.getY()) <= 175) {
                        if (Math.abs(simple_bullet_point.getX() - zombie_location.getX()) <= 210) {
                            hero.shotAttack(rover.zombie);
                            return false;
                        }
                    }
                    MarioWindow.delay(200);
                }

                if (simple_bullet_point.getX() > 1900) {
                    return false;
                }
            }
            return true;
        }
}
