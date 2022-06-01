package com.engeto.lekce12;

import com.engeto.lekce12.entity.UcitelEntity;
import com.engeto.lekce12.repository.UcitelRepository;
import org.springframework.stereotype.Service;

@Service
public class UcitelService {

    //@Autowired     //doplní správnou třídu repozitáře
    //public UcitelRepository ucitelRepository;

    public UcitelService(UcitelRepository ucitelRepository) {
        this.ucitelRepository = ucitelRepository;
    }

    final UcitelRepository ucitelRepository;

    public UcitelEntity getUcitelById(Long id) {
        return ucitelRepository.findById(id).orElseThrow();  //orElseThrow pokud nenajde, vyhodí vyjimku
//        return ucitelRepository.findById(id).orElse(null);  //vrátí prázdnou hodnotu
    }

    public UcitelEntity saveUcitel(UcitelEntity ucitel) {
        return ucitelRepository.save(ucitel);
    }

    public Iterable<UcitelEntity> getAllUcitel() {
        return ucitelRepository.findAll();
    }

    public void deleteUcitelById(Long id) {
        ucitelRepository.deleteById(id);
    }
}
