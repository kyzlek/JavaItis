package ru.itis.services;

import ru.itis.dao.OwnersDao;
import ru.itis.models.Owner;
import ru.itis.utils.Verifier;

import java.util.List;

import static ru.itis.utils.Verifier.verifyUserExist;

public class OwnersServiceImpl implements OwnerService {
    //СЕРВИС ПО РАБОТЕ С ПОЛЬЗОВАТЕЛЕМ
        // НАЙТИ ПОЛЬЗОВАТЕЛЯ
        // ОБНОВИТЬ ПОЛЬЗОВАТЕЛЯ

    private OwnersDao ownersDao;

    public OwnersServiceImpl(OwnersDao ownersDao) {
        this.ownersDao = ownersDao;
    }
    //НАйти пользователья по id
    public Owner findUserById(int id) {
        return ownersDao.find(id);
    }
    //Обновить пользователя
    public void updateOwner(Owner owner) {
        //Существует ли пользователь с данным id?
        verifyUserExist(owner.getId());
        //Обновить пользователя
        this.ownersDao.update(owner);
    }

    public List<Owner> getAllOwners(){
        return ownersDao.getAllOwners();
    }

    public void addNewOwner(Owner owner){
        ownersDao.addNewOwner(owner);
    }
}
