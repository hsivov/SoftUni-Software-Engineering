package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentSeedRootDto {

    @XmlElement(name = "apartment")
    private List<ApartmentSeedDto> apartmentSeedDtos;

    public List<ApartmentSeedDto> getApartmentSeedDtos() {
        return apartmentSeedDtos;
    }

    public void setApartmentSeedDtos(List<ApartmentSeedDto> apartmentSeedDtos) {
        this.apartmentSeedDtos = apartmentSeedDtos;
    }
}
