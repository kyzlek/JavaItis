package ru.itis;

import com.google.common.base.Splitter;
import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;
import ru.itis.service.SimpleUsersService;
import ru.itis.service.SimpleUsersServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Создание пользователя
        UsersDao usersDao = new UsersDaoFileBasedImpl("C:\\Users\\Kyzlek_pc\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\users.txt");

        //Вызов метода, который проверят зарегистрированность пользователя
        SimpleUsersService service = new SimpleUsersServiceImpl(usersDao);

        System.out.println("Ввведи информацию про пользователя:");
        Splitter splitter = Splitter.on(" ");
        List<String> lines = splitter.splitToList(scanner.nextLine());
        try{
            usersDao.save(new User(lines.get(0), lines.get(1), Integer.parseInt(lines.get(2)), Integer.parseInt(lines.get(3))));
        }catch(IndexOutOfBoundsException e){
           System.out.println("Вы ввели неккоректные данные!");
        }



        System.out.println("Ввведи id пользователя которую хочешь удалить:");
        try{
            usersDao.delete(Integer.parseInt(scanner.nextLine()));
        }catch (NullPointerException e){
            System.out.println("Вы ввели неккоректные данные");
        }

        System.out.println("Ввведи id пользователя которую хочешь вывести на экран:");
        System.out.println(usersDao.get(Integer.parseInt(scanner.nextLine())).getName());


        System.out.println(service.isRegistered("asd", "123"));
    }
}