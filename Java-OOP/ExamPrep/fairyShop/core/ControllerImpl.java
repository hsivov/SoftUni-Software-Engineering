package ExamPrep.fairyShop.core;

import ExamPrep.fairyShop.models.*;
import ExamPrep.fairyShop.repositories.HelperRepository;
import ExamPrep.fairyShop.repositories.PresentRepository;
import ExamPrep.fairyShop.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static ExamPrep.fairyShop.common.ConstantMessages.*;
import static ExamPrep.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Present> presentRepository;
    private Repository<Helper> helperRepository;

    private int presentCount = 0;

    public ControllerImpl() {
        this.presentRepository = new PresentRepository();
        this.helperRepository = new HelperRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;

        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        if (helperRepository.findByName(helperName) == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Helper helper = helperRepository.findByName(helperName);
        Instrument instrument = new InstrumentImpl(power);

        helper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);

        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> suitableHelpers = helperRepository.getModels().stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        Present present = presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();

        long brokenInstrumentsCount = 0;
        for (Helper suitableHelper : suitableHelpers) {

            shop.craft(present, suitableHelper);
            brokenInstrumentsCount = suitableHelper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (present.isDone()) {
                presentCount++;
                break;
            }
        }

        String output = present.isDone() ?
                "done" :
                "not done";
        return String.format(PRESENT_DONE, presentName, output) + String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstrumentsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!%n", presentCount))
                .append("Helpers info:");
        for (Helper helper : helperRepository.getModels()) {
            sb.append(System.lineSeparator());
            sb.append(helper);
        }

        return sb.toString();
    }
}
