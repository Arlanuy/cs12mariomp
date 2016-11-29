package cs12mariomp;
import java.awt.*;
class LQVGO extends GameObject {
    ZombiePila q;

    public LQVGO(ZombiePila q) {
        this.q = q;
    }

    public void paint(Graphics2D g2d) {
        NodeZombie rover;
        rover = q.head;
        while (rover != null) {
			g2d.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
			g2d.setColor( Color.GREEN );
			g2d.drawString( String.format( "HP: %s", rover.zombie.getHP()), rover.zombie.getZGT().getPointCM().getX(), rover.zombie.getZGT().getPointCM().getY() + 90);
            rover = rover.next;
        }
    }
}
