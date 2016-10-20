package ru.itis;

import ru.itis.dao.OwnersDao;
import ru.itis.factories.DaoFactory;
import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.services.OwnerService;
import ru.itis.services.OwnersServiceImpl;

public class Main {
    public static void main(String[] args) {

        //Создается сначала ownerService //сlass OwnersService
            //Создается ownersDao //class OwnersDao
                //Создается connection //class Connectionfactory
        //Каждый singleton (только один объект)

        OwnerService ownerService = ServiceFactory.getInstance().getOwnerService();



        //Создается экземпляр класса Owner
        //Ищем владельца по id
        Owner owner = ownerService.findUserById(2);

        //Ввыводим владельца
        System.out.println(owner);

        //Создаем нового владельца
        //Owner owner1 = new Owner(4, "AAAAAAAAAAAAA");
        ownerService.addNewOwner(new Owner(5, "Shaukat"));
        //Добавляем его в БД ()
        //ownerService.updateOwner(owner1);

        owner = ownerService.findUserById(3);

        System.out.println(owner);

    }
}
