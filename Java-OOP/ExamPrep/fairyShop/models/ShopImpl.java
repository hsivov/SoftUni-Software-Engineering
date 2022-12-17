package ExamPrep.fairyShop.models;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {

        Collection<Instrument> instruments = helper.getInstruments();

        for (Instrument instrument : instruments) {

            while (!instrument.isBroken()) {
                present.getCrafted();
                helper.work();
                instrument.use();

                if (!helper.canWork()) {
                    return;
                }
                if (present.isDone()) {
                    return;
                }
            }

        }
    }
}
