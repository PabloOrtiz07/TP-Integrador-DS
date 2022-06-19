package Apis.dto;

import java.util.ArrayList;
import java.util.List;

public class PaisesResponse{

    List<PaisResponse> paises = new ArrayList<>();

    public List<PaisResponse> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisResponse> paises) {
        this.paises = paises;
    }
}
