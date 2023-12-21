package class1.ex;

public class MovieReviewMain1 {
    public static void main(String[] args) {
        MovieReview mr1 = new MovieReview();
        mr1.title = "제목 1";
        mr1.review = "리뷰 1";

        MovieReview mr2 = new MovieReview();
        mr2.title = "제목 2";
        mr2.review = "리뷰 2";

        System.out.println(mr1.title + " " + mr1.review);
        System.out.println(mr2.title + " " + mr2.review);



    }
}
