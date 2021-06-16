package com.example.fidelyss;

import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiHandler {

    @FormUrlEncoded
    @POST("fidelysapi/inscription.php")
    Call<user> insertUser(
            @Field("id") String var1,
            @Field("sexe") String var2,
            @Field("nom") String var3,
            @Field("prenom") String var4,
            @Field("datenaiss") Date var5,
            @Field("email") String var6,
            @Field("nationalite") String var7,
            @Field("adressedomicile") String var8,
            @Field("ville") String var9,
            @Field("codepostal") String var10,
            @Field("pays") String var11,
            @Field("teldomicile") String var12,
            @Field("telmobile") String var13
    );

    @FormUrlEncoded
    @POST("fidelysapi/verify.php")
    Call<String> verify(
            @Field("user") String var1,
            @Field("token") String var2
        );

    @FormUrlEncoded
    @POST("fidelysapi/checkuser.php")
    Call<user> check(
            @Field("cin") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/forgotpin.php")
    Call<String> forgotpin(
            @Field("id") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/login.php")
    Call<client> selectUser(
            @Field("id") String var1,
            @Field("pin") String var2
        );

    @FormUrlEncoded
    @POST("fidelysapi/mouvements.php")
    Call<mouvement> getMvt(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/transactions.php")
    Call<List<transaction>> getTransaction(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/miles.php")
    Call<String> buyMiles(
            @Field("client") String var1,
            @Field("quantite") String var2,
            @Field("type") String var3,
            @Field("id") String var4

    );

    @FormUrlEncoded
    @POST("fidelysapi/updateinfo.php")
    Call<client> updateInf(
            @Field("id") String var1,
            @Field("nom") String var2,
            @Field("prenom") String var3,
            @Field("sexe") String var4,
            @Field("datenaiss") String var5
    );

    @FormUrlEncoded
    @POST("fidelysapi/updateinfo2.php")
    Call<client> updateInf2(
            @Field("id") String var1,
            @Field("cin") String var2,
            @Field("adr") String var3,
            @Field("teld") String var4,
            @Field("telm") String var5,
            @Field("ville") String var6,
            @Field("cp") String var7,
            @Field("nationalite") String var8,
            @Field("pays") String var9

    );

    @FormUrlEncoded
    @POST("fidelysapi/updateinfo3.php")
    Call<client> updateInf3(
            @Field("id") String var1,
            @Field("classeh") String var2,
            @Field("type") String var3,
            @Field("assistance") String var4,
            @Field("paiement") String var5,
            @Field("pref") String var6,
            @Field("habitude") String var7
    );

    @FormUrlEncoded
    @POST("fidelysapi/changeemail.php")
    Call<client> updateEmail(
            @Field("client") String var1,
            @Field("email") String var2,
            @Field("newemail") String var3
    );

    @FormUrlEncoded
    @POST("fidelysapi/reclamation.php")
    Call<reclamation> submitComplaint(
            @Field("client") String var1,
            @Field("titre") String var2,
            @Field("description") String var3
    );

    @FormUrlEncoded
    @POST("fidelysapi/reclamationencours.php")
    Call<List<reclamation>> getReclamationEncours(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/reclamationresolu.php")
    Call<List<reclamation>> getReclamationResolu(
            @Field("client") String var1
    );

    @FormUrlEncoded
    @POST("fidelysapi/achatbillet.php")
    Call<billet> buyTicket(
            @Field("client") String var1,
            @Field("de") String var2,
            @Field("vers") String var3,
            @Field("type") String var4,
            @Field("datealler") String var5,
            @Field("dateretour") String var6,
            @Field("classe") String var7,
            @Field("prix") int var8
    );

    @FormUrlEncoded
    @POST("fidelysapi/billet.php")
    Call<List<billet>> getBillet(
            @Field("client") String var1
    );


}
