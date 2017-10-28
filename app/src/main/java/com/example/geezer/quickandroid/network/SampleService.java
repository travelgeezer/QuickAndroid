package com.example.geezer.quickandroid.network;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Created by geezer. on 28/10/2017.
 */

public final class SampleService {
    private static final String API_URL = "https://api.github.com";

    public static class Contributor {
        private final String login;
        private final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }

        @Override
        public String toString() {
            return "Contributor{" +
                    "login='" + login + '\'' +
                    ", contributions=" + contributions +
                    '}';
        }
    }

    public interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo
        );
    }

    public static List<Contributor> getContributors(final String owner, final String repo) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHub gitHub = retrofit.create(GitHub.class);

        Call<List<Contributor>> call = gitHub.contributors(owner, repo);
        return call.execute().body();
    }
}
