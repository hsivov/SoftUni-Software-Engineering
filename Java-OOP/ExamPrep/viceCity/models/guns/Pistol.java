package ExamPrep.viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int INITIAL_TOTAL_BULLETS = 100;
    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
    }

    @Override
    public boolean canFire() {
        if (getBulletsPerBarrel() == 0) {
            reload();
        }
        return getBulletsPerBarrel() > 0;
    }

    private void reload() {
        if (getTotalBullets() - BULLETS_PER_BARREL >= 0) {
            setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
            setBulletsPerBarrel(BULLETS_PER_BARREL);
        }
    }

    @Override
    public int fire() {
        if (canFire()) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }
        return 1;
    }
}
