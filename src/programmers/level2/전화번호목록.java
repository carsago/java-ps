package programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i].startsWith(phone_book[i+1]) || phone_book[i].startsWith(phone_book[i+1])) {
                    return false;
            }
        }
        return answer;
    }
}
