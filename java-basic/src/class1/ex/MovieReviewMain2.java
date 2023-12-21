package class1.ex;

public class MovieReviewMain2 {
    public static void main(String[] args) {
        MovieReview mr1 = new MovieReview();
        mr1.title = "제목 1";
        mr1.review = "리뷰 1";

        MovieReview mr2 = new MovieReview();
        mr2.title = "제목 2";
        mr2.review = "리뷰 2";

        MovieReview[] movieReviews = new MovieReview[]{mr1, mr2};
        for (int i = 0; i < movieReviews.length; i++) {
            System.out.println(movieReviews[i].title + " " + movieReviews[i].review);
        }


    }
}
