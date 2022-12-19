package Retake_19Dec2022.magicGame.models.region;

import Retake_19Dec2022.magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {

        Collection<Magician> wizards = new ArrayList<>();
        Collection<Magician> blackWidows = new ArrayList<>();

        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizards.add(magician);
            } else if (magician.getClass().getSimpleName().equals("BlackWidow")) {
                blackWidows.add(magician);
            }
        }


        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            int damage;
            for (Magician wizard : wizards) {
                for (Magician blackWidow : blackWidows) {
                    damage = wizard.getMagic().fire();
                    if (damage > 0) {
                        blackWidow.takeDamage(damage);
                    }

                    damage = blackWidow.getMagic().fire();
                    if (damage > 0) {
                        wizard.takeDamage(damage);
                    }
                }
            }
            wizards.removeIf(w -> !w.isAlive());
            blackWidows.removeIf(b -> !b.isAlive());
        }

        return wizards.isEmpty() ? "Black widows win!" : "Wizards win!";
    }
}
