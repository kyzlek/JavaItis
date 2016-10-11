package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.parser.TokenType.EOL;

public class UsersDaoFileBasedImpl implements UsersDao {

    private BufferedReader fileReader;
    private FileWriter fileWriter;
    private static final String EOL = System.getProperty("line.separator");

    public UsersDaoFileBasedImpl(String fileName) {
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                User currentUser = parseStringAsUser(currentLine);
                result.add(currentUser);
                currentLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("SomeError");
        }

        return result;
    }

    @Override
    public User get(int userId) {
        List<User> listUser;
        listUser = getAll();

        if(listUser.size() != 0){
            for(int i=0; i<listUser.size(); i++){
                if(listUser.get(i).getId() == userId){
                    return listUser.get(i);
                }
            }
        }else System.out.print("Пользователь не найден!!!");
        return null;
    }

    @Override
    public void save(User user) {
        List<User> listUser;
        String inputUsersLine = "";
        listUser = getAll();
        listUser.add(user);
        for(int i=0; i<listUser.size(); i++){
                inputUsersLine = inputUsersLine + listUser.get(i).getName() +" "+ listUser.get(i).getPassword() +" "+ listUser.get(i).getAge() +" "+ listUser.get(i).getId()+ EOL;
        }
        try {
            fileWriter = new FileWriter("C:\\Users\\Kyzlek_pc\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\users.txt");
            fileWriter.write(inputUsersLine);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Добавлен");

        } catch (IOException e) {
            System.out.println("Не удалось создать файл");
        }

    }

    @Override
    public void delete(int userId) {
        List<User> listUser;
        String nameUserDelete = "";

        listUser = getAll();

        for(int i=0; i<listUser.size(); i++){
            if(listUser.get(i).getId() == userId){
                nameUserDelete = listUser.get(i).getName();
                listUser.remove(i);
            }
        }
        System.out.print(listUser.size());
        if(listUser.size() != 0){
            String outUsersLine = "";
            for(int i=0; i<listUser.size(); i++){
                outUsersLine = outUsersLine + listUser.get(i).getName() +" "+ listUser.get(i).getPassword() +" "+ listUser.get(i).getAge() +" "+ listUser.get(i).getId() + EOL;
            }
            try {
                fileWriter = new FileWriter("C:\\Users\\Kyzlek_pc\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\users.txt");
                fileWriter.write(outUsersLine);
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Пользователь " + nameUserDelete + " удален.");

            } catch (IOException e) {
                System.out.println("Не удалось создать файл");
            }
        }
        else {
            System.out.println("Пользователь для удаления не найден");
        }
    }

    private User parseStringAsUser(String line) {

        Splitter splitter = Splitter.on(" ");
        List<String> lines = splitter.splitToList(line);

        String name = lines.get(0);
        String password = lines.get(1);
        int age = Integer.parseInt(lines.get(2));
        int id = Integer.parseInt(lines.get(3));

        return new User(name, password, age, id);
    }
}
