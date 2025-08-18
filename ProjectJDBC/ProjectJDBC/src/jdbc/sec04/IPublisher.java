package jdbc.sec04;

import java.util.ArrayList;

public interface IPublisher {
    // 1. 출판사 번호, 이름 전체 목록
    public ArrayList<PublisherDTO> getAllPublisher();
}
