package video.user.repository;

import video.user.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static final Map<Integer, User> userDatabase = new HashMap<>();

    // 회원 추가 기능
    public void addUser(User user) {
        userDatabase.put(user.getUserNumber(), user);
    }

    // 이름을 통해 회원 검색 -> 동명이인이 있다면 모두 리턴하기 위해 List 리턴 타입 설정
    public List<User> findUserByName(String userName) {
        List<User> userList = new ArrayList<>();

        // Map을 반복 처리하기 위해 key들을 Set으로 반환.
        for (int key : userDatabase.keySet()) {
            User user = userDatabase.get(key); // key값을 통해 User객체를 얻기.
            if(user.getUserName().equals(userName)) { // User 객체의 name이 매개값으로 받은 name과 같다면
                userList.add(user); // 리스트에 객체를 추가
            }
        }

        return userList;
    }

    public User deleteUser(int delUserNum) {
        return userDatabase.remove(delUserNum);
    }

    public User findUserByNumber(int userNumber) {
        return userDatabase.get(userNumber);
    }
}