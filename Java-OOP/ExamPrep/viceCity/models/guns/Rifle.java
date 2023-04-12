package ExamPrep.viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int BULLETS_PER_BARREL = 50;
    private static final int INITIAL_TOTAL_BULLETS = 500;
    public Rifle(String name) {
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
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setBulletsPerBarrel(BULLETS_PER_BARREL);
    }

    @Override
    public int fire() {
        if (canFire()) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
        }
        return 5;
    }
}
