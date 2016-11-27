package cs12mariomp;
public class NodeZombie {
    public NodeZombie next;
    public Zombie zombie;

    public NodeZombie (Zombie zombie) {
        this.zombie = zombie;
    }
}
