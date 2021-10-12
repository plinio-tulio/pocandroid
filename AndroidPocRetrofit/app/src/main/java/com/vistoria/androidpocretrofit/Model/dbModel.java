package com.vistoria.androidpocretrofit.Model;

import java.util.ArrayList;

public class dbModel {

    public ArrayList<dbModel.posts> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<dbModel.posts> posts) {
        this.posts = posts;
    }

    public static ArrayList<dbModel.comments> getComments() {
        return comments;
    }

    public static void setComments(ArrayList<dbModel.comments> comments) {
        dbModel.comments = comments;
    }

    ArrayList<dbModel.posts> posts;
    static ArrayList<dbModel.comments> comments;

    public class posts {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        String id;
        String title;
    }

    public class comments {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        String id;
        String body;
        String postId;
    }
}
