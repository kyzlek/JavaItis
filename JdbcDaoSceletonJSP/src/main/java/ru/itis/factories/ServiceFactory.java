package ru.itis.factories;


import ru.itis.dao.OwnersDao;
import ru.itis.services.OwnerService;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ServiceFactory {
    private static ServiceFactory instance;

    private Properties properties;

    private OwnerService ownerService;

    private ServiceFactory() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Kyzlek_pc\\Desktop\\JavaItis\\JdbcDaoSceletonJSP\\src\\main\\resources\\service.properties"));
            //Получает имя класса из property
            String serviceClassName = properties.getProperty("service.class");
            //ru.itis.services.OwnersServiceImpl

            Class clazz = Class.forName(serviceClassName);

            Constructor constructor = clazz.getConstructor(OwnersDao.class);
            //Получаем ownersDao
            this.ownerService = (OwnerService)constructor.newInstance(DaoFactory.getInstance().getOwnersDao());

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    static {
        instance = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public OwnerService getOwnerService() {
        return this.ownerService;
    }
}
