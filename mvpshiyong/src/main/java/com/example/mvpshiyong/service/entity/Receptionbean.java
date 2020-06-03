package com.example.mvpshiyong.service.entity;

import java.util.List;

public class Receptionbean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"title":"熊猫是肉食动物呢还是草食动物？","answerA":"食肉动物","answerB":"草食动物","answerC":"腐食动物","answerD":"杂食动物","answer":"D","analytic":""}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * title : 熊猫是肉食动物呢还是草食动物？
         * answerA : 食肉动物
         * answerB : 草食动物
         * answerC : 腐食动物
         * answerD : 杂食动物
         * answer : D
         * analytic :
         */

        private String title;
        private String answerA;
        private String answerB;
        private String answerC;
        private String answerD;
        private String answer;
        private String analytic;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAnswerA() {
            return answerA;
        }

        public void setAnswerA(String answerA) {
            this.answerA = answerA;
        }

        public String getAnswerB() {
            return answerB;
        }

        public void setAnswerB(String answerB) {
            this.answerB = answerB;
        }

        public String getAnswerC() {
            return answerC;
        }

        public void setAnswerC(String answerC) {
            this.answerC = answerC;
        }

        public String getAnswerD() {
            return answerD;
        }

        public void setAnswerD(String answerD) {
            this.answerD = answerD;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getAnalytic() {
            return analytic;
        }

        public void setAnalytic(String analytic) {
            this.analytic = analytic;
        }
    }
}
