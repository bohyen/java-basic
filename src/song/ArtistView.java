package song;

import util.Utility;

import static util.Utility.*;

// 화면단을 담당하는 클래스(콘솔)
// 대부분의 기능을 static으로 선언하여 객체생성 없이도 화면을 띄울 수 있게 설계
public class ArtistView {

    private static ArtistRepository ar;

    static {
        ar = new ArtistRepository();
    }

    // 메인 실행 기능
    public static void start() {

        // 세이브 파일 로드
        ar.loadData();

        while (true) {
            System.out.println("\n\n****** 음악 관리 프로그램 ******");
            System.out.println("# 1. 노래 등록하기");
            System.out.println("# 2. 노래 정보 검색");
            System.out.println("# 3. 현재까지의 데이터 저장하기");
            System.out.println("# 4. 프로그램 종료");
            makeLine();

            System.out.println("\n원하시는 메뉴의 번호를 입력하세요!");
            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    insertProcess();
                    break;
                case "2":
                    searchProcess();
                    break;
                case "3":
                    ar.saveData();
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // 프로그램 강제 종료.
                    break;
                default:
                    System.out.println("# 메뉴를 잘못 선택하셨습니다.");
            }

        }

    }

    // 2번 메뉴에 대한 입출력 실행 내용
    private static void searchProcess() {

        System.out.println("\n# 검색할 가수명을 입력하세요.");
        String artistName = input("- 가수명: ");

        if (ar.isRegisted(artistName)) {
            System.out.printf("\n# %s 가수의 노래 목록\n", artistName);
            makeLine();

            ar.showSongList(artistName);

        } else {
            System.out.println("\n# 해당 가수는 등록되지 않았습니다.");
        }

    }

    // 1번 메뉴에 대한 입출력 실행 내용
    private static void insertProcess() {

        System.out.println("\n# 노래 등록을 시작합니다.");
        String artistName = input("- 가수명: ");
        String songName = input("- 노래명: ");

        // 기존에 등록된 가수인가?
        if (!ar.isRegisted(artistName)) {
            // 아니다 -> 새 객체를 생성해서 정보를 저장한다.
            ar.addNewArtist(artistName, songName);
            System.out.printf("\n# %s의 정보가 신규 등록되었습니다.\n", artistName);
        } else {
            // 그렇다 -> 새로운 가수 정보를 생성하는 것이 아닌, 기존 가수 정보에서 노래만 추가.
            boolean flag = ar.addNewSong(artistName, songName);
            if(!flag) {
                System.out.printf("\n# [%s]곡은 이미 등록된 노래입니다.\n", songName);
            } else {
                System.out.printf("\n# %s 가수의 노래목록에 %s 곡이 추가되었습니다.\n"
                        , artistName, songName);
            }

        }

    }

}