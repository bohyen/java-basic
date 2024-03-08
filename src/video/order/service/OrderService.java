package video.order.service;

import video.common.AppService;
import video.movie.domain.Movie;
import video.movie.repository.MovieRepository;
import video.order.domain.Order;
import video.ui.AppUi;
import video.user.domain.User;
import video.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static video.ui.AppUi.*;

public class OrderService implements AppService {

    private final MovieRepository movieRepository = new MovieRepository();
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void start() {
        while (true) {
            orderManagementScreen();
            int selection = inputInteger(">>> ");

            switch (selection) {
                case 1:
                    processOrderDvd();
                    break;
                case 2:

                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n### 메뉴를 다시 입력하세요.");
            }


        }
    }

    // DVD 대여 서비스 비즈니스 로직
    private void processOrderDvd() {
        while (true) {
            System.out.println("\n============================ 대여관리 시스템을 실행합니다. ============================");
            System.out.println("[ 1. 대여 가능 DVD 목록 보기 | 2. 대여중인 영화 반납예정일 확인하기 | 3. 이전으로 돌아가기 ]");
            int selection = inputInteger(">>> ");

            switch (selection) {
                case 1:
                    showRentalPossibleList();
                    break;
                case 2:

                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n### 메뉴를 다시 입력하세요.");
            }

        }
    }

    // 대여 가능한 DVD 목록 보기
    private void showRentalPossibleList() {
        List<Movie> movieList = movieRepository.searchByRental(true);
        int count = movieList.size();

        List<Integer> movieNums = new ArrayList<>();

        if (count > 0) {
            System.out.printf("\n==================================== 검색 결과 (총 %d건) ====================================\n", count);
            for (Movie movie : movieList) {
                System.out.println(movie);
                movieNums.add(movie.getSerialNumber());
            }
            System.out.println("==========================================================================================");
            System.out.println("### 대여할 DVD의 번호를 입력하세요.");
            int movieNumber = inputInteger(">>> ");

            if (movieNums.contains(movieNumber)) {
                rentalProcess(movieNumber);
            } else {
                System.out.println("\n### 대여가 가능한 영화 목록중에 선택해야 합니다.");
            }
        } else {
            System.out.println("\n### 대여 가능한 DVD가 없습니다 ㅠㅠ");
        }
    }

    private void rentalProcess(int movieNumber) {

        Movie rentalMovie = movieRepository.searchMovie(movieNumber);
        System.out.printf("\n### [%s] DVD를 대여합니다.\n", rentalMovie.getMovieName());
        System.out.println("### 대여자의 이름을 입력하세요.");
        String name = inputString(">>> ");

        List<User> users = userRepository.findUserByName(name);

        if(users.size() > 0) {
            List<Integer> userNums = new ArrayList<>();
            System.out.println("\n===================================== 회원 조회 결과 =====================================");
            for (User user : users) {
                System.out.println(user);
                userNums.add(user.getUserNumber());
            }
            System.out.println("========================================================================================");
            System.out.println("## 대여할 회원의 회원번호를 입력하세요.");
            int userNumber = inputInteger(">>> ");

            if (userNums.contains(userNumber)) {
                // 대여 완료 처리
                User rentalUser = userRepository.findUserByNumber(userNumber); // 렌탈 유저 정보 획득.
                rentalMovie.setRental(true); // 대여상태를 대여중으로 변경
                rentalMovie.setRentalUser(rentalUser); // 영화 객체에 렌탈 유저 등록

                rentalUser.setTotalPaying(rentalMovie.getCharge()); // 영화 대여 금액을 회원 총 결제금액에 누적 갱신

                // 새로운 주문 생성
                Order newOrder = new Order(rentalUser, rentalMovie);
                rentalUser.addOrder(newOrder); // 회원 대여 목록에 주문을 추가.

                String phoneNumber = rentalUser.getPhoneNumber();

                // lastIndexOf(str): 해당 문자열의 위치를 뒤에서부터 탐색.
                // 뒤에서부터 탐색을 시작해서 "-"을 찾아라 -> 그 "-" 이후로부터 끝까지 추출해라.
                System.out.printf("\n### [%s(%s) 회원님] 대여 처리가 완료되었습니다. 감사합니다!\n"
                        , rentalUser.getUserName(), rentalUser.getPhoneNumber().substring(phoneNumber.lastIndexOf("-")));

                System.out.printf("### 현재 등급: [%s], 총 누적 결재금액: %d원\n", rentalUser.getGrade(), rentalUser.getTotalPaying());

            } else {
                System.out.println("\n### 검색된 회원의 번호를 입력하세요.");
            }

        } else {
            System.out.println("\n### 대여자 정보가 없습니다.");
        }


    }


}