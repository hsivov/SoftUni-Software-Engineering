package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownSeedRootDto {

    @XmlElement(name = "town")
    private List<TownSeedDto> towns;

    public List<TownSeedDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownSeedDto> towns) {
        this.towns = towns;
    }
}
