package Game;

import Enums.EntityType;

public class Entity {
    private final int x;
    private final int y;
    private final EntityType type;


    public Entity(int x, int y , EntityType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EntityType getType() {
        return type;
    }

    public boolean isWall() {
        return type == EntityType.WAlL;
    }

    public boolean isDoor() {
        return type == EntityType.DOOR;
    }

    public boolean isPortal() {
        return type == EntityType.PORTAL;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
