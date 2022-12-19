package Retake_19Dec2022.magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() >= 10) {
            setBulletsCount(getBulletsCount() - 10);
            return 10;
        }
        return 0;
    }
}
