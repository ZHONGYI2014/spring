package bean;

/**
 * 新闻提供者
 */
public class NewsProvider {

    private NewsListener newsListener;

    private String msg;

//    public NewsProvider(NewsListener newsListener, String msg) {
//        this.newsListener = newsListener;
//        this.msg = msg;
//    }

    public void setNewsListener(NewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void provideNews() {
        newsListener.catchNews(msg);
    }
}
