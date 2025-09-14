public class Book {
    private String title;
    private String author;
    private int page;
    private int price;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.page = builder.page;
        this.price = builder.price;
    }

    public static class Builder{
        private String title;
        private String author;
        private int page;
        private int price;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder page(int page){
            this.page = page;
            return this;
        }

        public Builder price(int price){
            this.price = price;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", page=" + page + ", price=" + price + "]";
    }

    // 자바 빈 패턴 : private, getter, setter
    // 기본 생성자로 인스턴스 생성 + setter로 초기화
    // 가독성이 좋음 ex) Book book = new Book();
    //                      book.setAuthor("J.K.Rolling");
    // immutable 객체를 생성할 수 없음

    // [점층적 생성자 패턴]
    // 매개변수가 있는 생성자를 사용해서 인스턴스화와 동시에 초기화
    // 가독성이 안좋음 ex) new Book("harry potter", "J.K.Rolling", 9000, 9000); - 각 매개변수가 뭔지 알기 어려움
    // immutable 객체를 생성할 수 있음

    // [builder 패턴]
    // 가독성이 좋고 immutable 객체도 만들 수 있다

}
