public class Run {
    public static void main(String[] args) {
        Book book = new Book.Builder()
                            .title("해리포터")
                            .author("롤링")
                            .price(9000)
                            .page(300)
                            .build();

        System.out.println(book);
    }
}
