package Retake_19Dec2022.magicGame.models.magics;

import Retake_19Dec2022.magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{

    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }
}
